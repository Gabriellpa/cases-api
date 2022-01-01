package br.com.grabriellpa.casesapi.v1.enums;

import lombok.Getter;

import java.io.Serializable;

public enum CasesEnum implements Serializable {
    CONFIRMED("/time_series_covid19_confirmed_global.csv"),
    DEATHS("/time_series_covid19_deaths_global.csv"),
    RECOVERED("/time_series_covid19_recovered_global.csv");

    @Getter
    String path;

    CasesEnum(String patth) {
        this.path = path;
    }
}
