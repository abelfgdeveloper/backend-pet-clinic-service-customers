package es.abelfgdeveloper.petclinic.customers.api.owner.validation;

import es.abelfgdeveloper.petclinic.customers.api.owner.OwnerConstants;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.exception.InternalServerException;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OwnerValidator {

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

  public void validate(UpdateOwnerRequestResource owner) {
    if (owner == null) {
      throw new BadRequestException(ErrorCodes.UPDATE_OWNER_REQUEST_RESOURCE_NOT_NULL);
    }
    validateFirstName(owner.getFirstName());
    validateLastName(owner.getLastName());
    validateTelephone(owner.getTelephone());
    validateEmail(owner.getEmail());
  }

  public void validate(List<OwnerResponseResource> owners) {
    if (!owners.isEmpty()) {
      for (OwnerResponseResource owner : owners) {
        validate(owner);
      }
    }
  }

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

  private void validateId(String id) {
    if (id == null) {
      throw new BadRequestException(ErrorCodes.OWNER_ID_NOT_NULL);
    }
  }

  private void validateIdentificationDocument(String identificationDocument) {
    if (identificationDocument == null) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_NOT_NULL);
    }

    if (identificationDocument.length()
        < OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH);
    }

    if (identificationDocument.length()
        > OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH);
    }
    if (!identificationDocument.matches(
        OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_PATTERN)) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_PATTERN);
    }
  }

  private void validateFirstName(String firstName) {
    if (firstName == null) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_NOT_NULL);
    }

    if (firstName.length() < OwnerConstants.OWNER_RESOURCE_FIRST_NAME_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_LENGTH);
    }

    if (firstName.length() > OwnerConstants.OWNER_RESOURCE_FIRST_NAME_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_LENGTH);
    }
  }

  private void validateLastName(String lastName) {
    if (lastName == null) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_NOT_NULL);
    }

    if (lastName.length() < OwnerConstants.OWNER_RESOURCE_LAST_NAME_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_LENGTH);
    }

    if (lastName.length() > OwnerConstants.OWNER_RESOURCE_LAST_NAME_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_FIRST_NAME_LENGTH);
    }
  }

  private void validateTelephone(String telephone) {
    if (telephone != null
        && telephone.length() < OwnerConstants.OWNER_RESOURCE_TELEPHONE_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_TELEPHONE_LENGTH);
    }

    if (telephone != null
        && telephone.length() > OwnerConstants.OWNER_RESOURCE_TELEPHONE_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_TELEPHONE_LENGTH);
    }
    if (telephone != null && !telephone.matches(OwnerConstants.OWNER_RESOURCE_TELEPHONE_PATTERN)) {
      throw new BadRequestException(ErrorCodes.OWNER_TELEPHONE_PATTERN);
    }
  }

  private void validateEmail(String email) {
    if (email == null) {
      throw new BadRequestException(ErrorCodes.OWNER_EMAIL_NOT_NULL);
    }

    if (email.length() < OwnerConstants.OWNER_RESOURCE_EMAIL_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_EMAIL_LENGTH);
    }

    if (email.length() > OwnerConstants.OWNER_RESOURCE_EMAIL_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_EMAIL_LENGTH);
    }
    if (!email.matches(OwnerConstants.OWNER_RESOURCE_EMAIL_PATTERN)) {
      throw new BadRequestException(ErrorCodes.OWNER_EMAIL_PATTERN);
    }
  }

  private void validateCreateAt(LocalDate createAt) {
    if (createAt == null) {
      throw new BadRequestException(ErrorCodes.OWNER_CREATE_AT_NOT_NULL);
    }
  }
}
