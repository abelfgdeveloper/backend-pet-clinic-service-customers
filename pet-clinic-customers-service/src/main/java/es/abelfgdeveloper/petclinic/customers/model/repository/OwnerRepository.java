package es.abelfgdeveloper.petclinic.customers.model.repository;

import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OwnerRepository
    extends JpaRepository<OwnerEntity, String>, JpaSpecificationExecutor<OwnerEntity> {

  Optional<OwnerEntity> findByIdentificationDocument(String identificationDocument);
}
