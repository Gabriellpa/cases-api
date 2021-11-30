package br.com.grabriellpa.casesapi.v1.controller;

import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import br.com.grabriellpa.casesapi.v1.service.CasesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// TODO alterar para GRPC
@RestController
@RequiredArgsConstructor
@Deprecated
public class CasesController {

    private final CasesService casesService;

    @GetMapping
    public ResponseEntity<Void> collectCasesData(@RequestHeader(value = "Cases_Type", defaultValue = "DEATHS") CasesEnum casesType) {
        casesService.getData(casesType);
        System.out.println("CALLED 1");

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/na")
    public ResponseEntity<Void> teste1(@RequestHeader(value = "Cases_Type", defaultValue = "DEATHS") CasesEnum casesType) {
        System.out.println("TESTE 1");
        return ResponseEntity.noContent().build();
    }

}
