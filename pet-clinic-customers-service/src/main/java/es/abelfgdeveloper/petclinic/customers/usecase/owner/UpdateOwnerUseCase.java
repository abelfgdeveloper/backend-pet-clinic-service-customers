package es.abelfgdeveloper.petclinic.customers.usecase.owner;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;

public interface UpdateOwnerUseCase {

  Owner execute(String id, Owner owner);
}
