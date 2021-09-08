package br.com.grabriellpa.casesapi.v1.entity;

import br.com.grabriellpa.casesapi.v1.model.Cases;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class CasesOccurrenceEntity {
//    @Id
//    @SequenceGenerator(
//            name = "cases_occurrence_sequence",
//            sequenceName = "cases_occurrence_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "cases_occurrence_sequence"
//    )
    private Long id;
    private String provinceState;
    private String countryRegion;
    private BigDecimal _lat;
    private BigDecimal _long;
    private List<Cases> casesPerDay;
}
