package es.abelfgdeveloper.petclinic.customers.usecase.owner.impl;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.CreateOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultCreateOwnerUseCase implements CreateOwnerUseCase {

  private final OwnerService ownerService;

  @Override
  public Owner execute(Owner owner) {
    return ownerService.create(owner);
  }
}
