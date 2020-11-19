package es.abelfgdeveloper.petclinic.customers.usecase.owner;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;

public interface FindOwnerByIdUseCase {

  Owner execute(String id);
}
