package br.com.grabriellpa.casesapi.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Cases {
    private String date;
    private String numberOfCases;
    
}
