package br.com.grabriellpa.casesapi.v1.converter;

import br.com.grabriellpa.casesapi.v1.model.Cases;
import org.apache.commons.collections4.MultiValuedMap;
import org.modelmapper.AbstractConverter;

import java.util.List;
import java.util.stream.Collectors;

public class CasesMapValueToObject extends AbstractConverter<MultiValuedMap<String, String>, List<Cases>>  {

    @Override
    protected List<Cases> convert(MultiValuedMap<String, String> source) {
        return source.entries().stream()
        .map(mapper -> Cases.builder().date(mapper.getKey()).numberOfCases(mapper.getValue()).build()).collect(Collectors.toList());
    }
    
}
