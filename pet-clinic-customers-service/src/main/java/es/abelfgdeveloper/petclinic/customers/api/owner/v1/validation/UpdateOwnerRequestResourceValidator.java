package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.springframework.stereotype.Component;

@Component
public class UpdateOwnerRequestResourceValidator extends OwnerValidator {

  public void validate(UpdateOwnerRequestResource owner) {
    if (owner == null) {
      throw new BadRequestException(ErrorCodes.UPDATE_OWNER_REQUEST_RESOURCE_NOT_NULL);
    }
    validateFirstName(owner.getFirstName());
    validateLastName(owner.getLastName());
    validateTelephone(owner.getTelephone());
    validateEmail(owner.getEmail());
  }
}
