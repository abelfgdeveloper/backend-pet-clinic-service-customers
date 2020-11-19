package es.abelfgdeveloper.petclinic.customers.model.repository;

import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, String> {

  Optional<OwnerEntity> findByIdentificationDocument(String identificationDocument);
}
