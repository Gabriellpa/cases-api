package br.com.grabriellpa.casesapi.v1.converter;

import br.com.grabriellpa.casesapi.v1.entity.CasesOccurrenceEntity;
import br.com.grabriellpa.casesapi.v1.model.Row;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RowConverter {

    private final ModelMapper modelMapper;

    public RowConverter(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.createTypeMap(Row.class, CasesOccurrenceEntity.class).addMappings(mapper -> mapper
                .using(new CasesMapValueToObject()).map(Row::getCasesPerDay, CasesOccurrenceEntity::setCasesPerDay));
    }

    public List<CasesOccurrenceEntity> toCasesOccurrenceEntities(List<Row> rows) {
        return modelMapper.map(rows, new TypeToken<List<CasesOccurrenceEntity>>() {
        }.getType());
    }

}
