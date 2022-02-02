package br.com.grabriellpa.casesapi.v1.service;

import br.com.grabriellpa.casesapi.v1.client.CoronaVirusGitHubCSSEGIClient;
import br.com.grabriellpa.casesapi.v1.converter.CsvConverter;
import br.com.grabriellpa.casesapi.v1.converter.RowConverter;
import br.com.grabriellpa.casesapi.v1.entity.CasesOccurrenceEntity;
import br.com.grabriellpa.casesapi.v1.entity.CasesUpdateEntity;
import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import br.com.grabriellpa.casesapi.v1.exception.DeltaTimeException;
import br.com.grabriellpa.casesapi.v1.repository.CasesOccurrenceRepository;
import br.com.grabriellpa.casesapi.v1.repository.CasesUpdateRepository;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CasesService {

    private final CoronaVirusGitHubCSSEGIClient client;
    private final CsvConverter csvConverter;
    private final RowConverter rowConverter;
    private final CasesOccurrenceRepository casesOccurrenceRepository;
    private final CasesUpdateRepository casesUpdateRepository;

    private final DateTimeFormatter ALL_POSSIBLE_DATE_FORMAT = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ofPattern("MM/dd/yy"))
            .appendOptional(DateTimeFormatter.ofPattern(("M/dd/yy")))
            .appendOptional(DateTimeFormatter.ofPattern(("MM/d/yy")))
            .appendOptional(DateTimeFormatter.ofPattern(("M/d/yy")))
            .toFormatter();

    public void processData(CasesEnum casesType) {
        processDataByType(casesType, false);
    }

    // MANUAL
    public void processDataTrigger(CasesEnum casesType, boolean force) {
        processDataByType(casesType, force);
    }

    /**
     * Processo para extrair casos de covid dependendo do tipo (Death, Confirmed, Recovered)
     * É realizado tratamento para evitar pegar duplicados no mesmo dia.
     *
     * @param type  Tipo do caso
     * @param force Se deve executar mesmo se já foi realizado
     */
    private void processDataByType(CasesEnum type, boolean force) {
        try {
            var delta = casesUpdateRepository.getByType(type);
            createUpdateDelta(delta, type);
            validDeltaTime(delta, force, type);
            var cases = fetchAndTransformData(type, delta);
            updateCases(cases);
            log.debug("[{}}] {}", type.name(), cases.size());
        } catch (DeltaTimeException e) {
            if (force) {
                throw e;
            }
        }
    }

    /**
     * TODO
     * @param type
     * @param delta
     * @return
     */
    private List<CasesOccurrenceEntity> fetchAndTransformData(CasesEnum type, CasesUpdateEntity delta) {
        try {
            var cases = rowConverter.toCasesOccurrenceEntities(csvConverter.stringToObject(client.getDataByType(type.getPath())));

            cases.forEach(casesOccurrenceEntity -> {
                casesOccurrenceEntity.setType(CasesEnum.CONFIRMED.name());
                casesOccurrenceEntity.setCasesPerDay(casesOccurrenceEntity.getCasesPerDay()
                        .stream()
                        .filter(item -> toAdd(item.getDate(), delta))
                        .collect(Collectors.toList()));
            });
            return cases.stream().filter(item -> !item.getCasesPerDay().isEmpty()).collect(Collectors.toList());
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException("INTERNAL ERROR");
        }
    }

    /**
     * TODO
     * @param delta
     * @param force
     * @param type
     */
    private void validDeltaTime(CasesUpdateEntity delta, boolean force, CasesEnum type) {
        if (Objects.nonNull(delta) && delta.getLastUpdate().isEqual(LocalDate.now()) && !force) {
            log.debug("[DONE OR IN PROGRESS] {}", type.name());
            throw new DeltaTimeException("[DONE OR IN PROGRESS] {}" + type.name());
        }
    }

    /**
     * Salva casos no banco
     *
     * @param casesData List de ocorrências de casos
     */
    private void updateCases(List<CasesOccurrenceEntity> casesData) {
        if (!casesData.isEmpty()) {
            casesOccurrenceRepository.saveAll(casesData);
        }
    }

    /**
     * Cria ou realiza o update da data de ultima atualização
     *
     * @param delta Data da ultima atualização, sem ser a que está sendo executada
     * @param type  Tipo de Case
     */
    private void createUpdateDelta(CasesUpdateEntity delta, CasesEnum type) {
        if (Objects.isNull(delta)) {
            var newDelta = new CasesUpdateEntity();
            newDelta.setType(type);
            newDelta.setLastUpdate(LocalDate.now());
            casesUpdateRepository.save(newDelta);
        } else {
            delta.setLastUpdate(LocalDate.now());
            casesUpdateRepository.save(delta);
        }
    }

    /**
     * Regra para validar se deve ou não ser adicionado na lista de ocorrências
     * como não é possivel filtrar por data ao coletar a data, é realizado um filtro
     * para envitar salvar casos duplicados no banco
     *
     * @param caseDate          Data da ocorrência de caso
     * @param casesUpdateEntity Data da ultima atualização
     * @return um boolean indicando se deve ou não adicionar na lista de ocorrências para ser salvo no banco.
     */
    private boolean toAdd(String caseDate, CasesUpdateEntity casesUpdateEntity) {
        if (Objects.isNull(casesUpdateEntity)) {
            return true;
        }
        var date = LocalDate.parse(caseDate, ALL_POSSIBLE_DATE_FORMAT);
        return date.isAfter(casesUpdateEntity.getLastUpdate()) || date.isEqual(casesUpdateEntity.getLastUpdate());
    }
}