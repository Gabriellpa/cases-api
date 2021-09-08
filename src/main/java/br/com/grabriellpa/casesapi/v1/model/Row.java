package br.com.grabriellpa.casesapi.v1.model;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.MultiValuedMap;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Row {
    @CsvBindByName(column = "Province/State")
    private String provinceState;
    @CsvBindByName(column = "Country/Region")
    private String countryRegion;
    @CsvBindByName(column = "Lat")
    private BigDecimal _lat;
    @CsvBindByName(column = "Long")
    private BigDecimal _long;
    @CsvBindAndJoinByName(column = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,2}", elementType = String.class)
    private MultiValuedMap<String, String> casesPerDay;
}
