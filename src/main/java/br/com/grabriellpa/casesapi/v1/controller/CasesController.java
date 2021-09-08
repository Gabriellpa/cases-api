package br.com.grabriellpa.casesapi.v1.controller;

import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import br.com.grabriellpa.casesapi.v1.service.CasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CasesController {

    private final CasesService casesService;

    @GetMapping
    public ResponseEntity<Void> collectCasesData(@RequestHeader(value = "Cases_Type", defaultValue = "DEATHS") CasesEnum casesType) {
        casesService.getData(casesType);

        return ResponseEntity.noContent().build();
    }

}
