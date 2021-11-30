package br.com.grabriellpa.casesapi.v1.entity;

import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class CasesUpdateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate lastUpdate;
    private CasesEnum type;
}
