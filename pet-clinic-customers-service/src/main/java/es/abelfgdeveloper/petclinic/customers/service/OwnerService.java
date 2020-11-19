package es.abelfgdeveloper.petclinic.customers.service;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import java.util.List;

public interface OwnerService {

  Owner create(Owner owner);

  Owner update(String id, Owner owner);

  void deleteById(String id);

  Owner findById(String id);

  List<Owner> findAll();
}
