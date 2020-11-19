package es.abelfgdeveloper.petclinic.customers.model.specification;

import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class OwnerSpecification {

  public Specification<OwnerEntity> notDeleted() {
    return (root, criteriaQuery, criteriaBuilder) ->
        criteriaBuilder.equal(root.get("deleted"), false);
  }
}
