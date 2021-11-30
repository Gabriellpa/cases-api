package br.com.grabriellpa.casesapi.v1.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CasesEntity {

    @Id
    @SequenceGenerator(
            name = "case_occurrence_sequence",
            sequenceName = "case_occurrence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "case_occurrence_sequence"
    )
    private Long id;
    private String date;
    private String numberOfCases;
}
