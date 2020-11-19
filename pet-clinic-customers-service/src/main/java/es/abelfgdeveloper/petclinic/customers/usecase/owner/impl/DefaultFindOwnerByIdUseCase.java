package es.abelfgdeveloper.petclinic.customers.usecase.owner.impl;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.FindOwnerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultFindOwnerByIdUseCase implements FindOwnerByIdUseCase {

  private final OwnerService ownerService;

  @Override
  public Owner execute(String id) {
    return ownerService.findById(id);
  }
}
