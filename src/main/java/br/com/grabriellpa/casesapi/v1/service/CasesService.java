package br.com.grabriellpa.casesapi.v1.service;

import br.com.grabriellpa.casesapi.v1.client.CoronaVirusGitHubCSSEGIClient;
import br.com.grabriellpa.casesapi.v1.converter.CsvConverter;
import br.com.grabriellpa.casesapi.v1.converter.RowConverter;
import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class CasesService {

    @Autowired
    private CoronaVirusGitHubCSSEGIClient client;
    @Autowired
    private CsvConverter csvConverter;
    @Autowired
    private RowConverter rowConverter;

    public void getData(CasesEnum casesType) {
        try {
            // TODO salvar no banco
            log.debug("TESTE DEBUG");
            switch (casesType) {
                case CONFIRMED:
                    var confirmeds = rowConverter.toCasesOccurrenceEntities(csvConverter.stringToObject(client.getConfirmed()));
                    log.info("[CONFIRMEDS] {}", confirmeds.size());
                    break;
                case RECOVERED:
                    var recovereds = rowConverter.toCasesOccurrenceEntities(csvConverter.stringToObject(client.getRecovered()));
                    log.info("[RECOVEREDS] {}", recovereds.size());
                    break;
                case DEATHS:
                    var deceases = rowConverter.toCasesOccurrenceEntities(csvConverter.stringToObject(client.getDeaths()));
                    log.info("[DECEASES] {}", deceases.size());
                    break;
            }

        } catch (CsvValidationException | IOException e) {
            log.info(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}