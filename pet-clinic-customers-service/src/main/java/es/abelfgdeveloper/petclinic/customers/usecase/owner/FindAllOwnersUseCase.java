package es.abelfgdeveloper.petclinic.customers.usecase.owner;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import java.util.List;

public interface FindAllOwnersUseCase {

  List<Owner> execute();
}
