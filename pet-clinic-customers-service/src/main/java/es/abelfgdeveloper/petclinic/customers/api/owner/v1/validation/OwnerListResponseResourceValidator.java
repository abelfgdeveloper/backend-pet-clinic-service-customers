package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OwnerListResponseResourceValidator extends OwnerValidator {

  private final OwnerResponseResourceValidator ownerResponseResourceValidator;

  public void validate(List<OwnerResponseResource> owners) {
    if (!owners.isEmpty()) {
      for (OwnerResponseResource owner : owners) {
        ownerResponseResourceValidator.validate(owner);
      }
    }
  }
}
