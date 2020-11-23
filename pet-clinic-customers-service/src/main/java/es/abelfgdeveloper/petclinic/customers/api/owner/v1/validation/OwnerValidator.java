package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.api.owner.OwnerConstants;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import java.time.LocalDate;

public abstract class OwnerValidator {

  protected void validateId(String id) {
    if (id == null) {
      throw new BadRequestException(ErrorCodes.OWNER_ID_NOT_NULL);
    }
  }

  protected void validateIdentificationDocument(String identificationDocument) {
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

  protected void validateFirstName(String firstName) {
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

  protected void validateLastName(String lastName) {
    if (lastName == null) {
      throw new BadRequestException(ErrorCodes.OWNER_LAST_NAME_NOT_NULL);
    }

    if (lastName.length() < OwnerConstants.OWNER_RESOURCE_LAST_NAME_MIN_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_LAST_NAME_LENGTH);
    }

    if (lastName.length() > OwnerConstants.OWNER_RESOURCE_LAST_NAME_MAX_LENGTH) {
      throw new BadRequestException(ErrorCodes.OWNER_LAST_NAME_LENGTH);
    }
  }

  protected void validateTelephone(String telephone) {
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

  protected void validateEmail(String email) {
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

  protected void validateCreateAt(LocalDate createAt) {
    if (createAt == null) {
      throw new BadRequestException(ErrorCodes.OWNER_CREATE_AT_NOT_NULL);
    }
  }
}
