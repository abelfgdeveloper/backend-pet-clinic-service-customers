package es.abelfgdeveloper.petclinic.customers.usecase.owner.impl;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.UpdateOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultUpdateOwnerUseCase implements UpdateOwnerUseCase {

  private final OwnerService ownerService;

  @Override
  public Owner execute(String id, Owner owner) {
    return ownerService.update(id, owner);
  }
}
