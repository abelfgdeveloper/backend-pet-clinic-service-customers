package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.common.exception.InternalServerException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseResourceValidator extends OwnerValidator {

  public void validate(OwnerResponseResource owner) {
    if (owner == null) {
      throw new InternalServerException(ErrorCodes.OWNER_RESPONSE_RESOURCE_NOT_NULL);
    }
    try {
      validateId(owner.getId());
      validateIdentificationDocument(owner.getIdentificationDocument());
      validateFirstName(owner.getFirstName());
      validateLastName(owner.getLastName());
      validateTelephone(owner.getTelephone());
      validateEmail(owner.getEmail());
      validateCreateAt(owner.getCreateAt());
    } catch (BadRequestException e) {
      throw new InternalServerException(e.getMessage(), e);
    }
  }
}
