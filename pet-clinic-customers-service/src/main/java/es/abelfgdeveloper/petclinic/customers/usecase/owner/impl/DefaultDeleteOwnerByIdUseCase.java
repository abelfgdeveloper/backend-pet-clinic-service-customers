package es.abelfgdeveloper.petclinic.customers.usecase.owner.impl;

import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.DeleteOwnerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultDeleteOwnerByIdUseCase implements DeleteOwnerByIdUseCase {

  private final OwnerService ownerService;

  @Override
  public void execute(String id) {
    ownerService.deleteById(id);
  }
}
