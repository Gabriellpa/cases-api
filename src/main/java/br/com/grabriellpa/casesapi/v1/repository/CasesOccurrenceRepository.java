package br.com.grabriellpa.casesapi.v1.repository;


import br.com.grabriellpa.casesapi.v1.entity.CasesOccurrenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasesOccurrenceRepository extends JpaRepository<CasesOccurrenceEntity, Long> {
    
}
