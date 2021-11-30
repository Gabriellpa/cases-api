package br.com.grabriellpa.casesapi.v1.repository;

import br.com.grabriellpa.casesapi.v1.entity.CasesUpdateEntity;
import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasesUpdateRepository extends JpaRepository<CasesUpdateEntity, Long> {

    CasesUpdateEntity getByType(CasesEnum type);

}