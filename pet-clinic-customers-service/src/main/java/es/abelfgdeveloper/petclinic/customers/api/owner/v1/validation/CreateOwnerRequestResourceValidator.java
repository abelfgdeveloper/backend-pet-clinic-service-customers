package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.springframework.stereotype.Component;

@Component
public class CreateOwnerRequestResourceValidator extends OwnerValidator {

  public void validate(CreateOwnerRequestResource owner) {
    if (owner == null) {
      throw new BadRequestException(ErrorCodes.CREATE_OWNER_REQUEST_RESOURCE_NOT_NULL);
    }
    validateIdentificationDocument(owner.getIdentificationDocument());
    validateFirstName(owner.getFirstName());
    validateLastName(owner.getLastName());
    validateTelephone(owner.getTelephone());
    validateEmail(owner.getEmail());
  }
}
