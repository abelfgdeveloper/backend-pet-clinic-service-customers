package es.abelfgdeveloper.petclinic.customers.usecase.owner.impl;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.FindAllOwnersUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultFindAllOwnersUseCase implements FindAllOwnersUseCase {

  private final OwnerService ownerService;

  @Override
  public List<Owner> execute() {
    return ownerService.findAll();
  }
}
