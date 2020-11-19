package es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response;

import es.abelfgdeveloper.petclinic.customers.api.owner.OwnerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = OwnerConstants.OWNER_RESPONSE_RESOURCE_DESCRIPTION)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OwnerResponseResource {

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_ID_DESCRIPTION,
      required = true,
      example = OwnerConstants.OWNER_RESOURCE_ID_EXAMPLE)
  private String id;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MAX_LENGTH,
      required = true,
      pattern = OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_PATTERN,
      example = OwnerConstants.OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_EXAMPLE)
  private String identificationDocument;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_FIRST_NAME_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_FIRST_NAME_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_FIRST_NAME_MAX_LENGTH,
      required = true,
      example = OwnerConstants.OWNER_RESOURCE_FIRST_NAME_EXAMPLE)
  private String firstName;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_LAST_NAME_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_LAST_NAME_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_LAST_NAME_MAX_LENGTH,
      required = true,
      example = OwnerConstants.OWNER_RESOURCE_LAST_NAME_EXAMPLE)
  private String lastName;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_TELEPHONE_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_TELEPHONE_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_TELEPHONE_MAX_LENGTH,
      required = false,
      pattern = OwnerConstants.OWNER_RESOURCE_TELEPHONE_PATTERN,
      example = OwnerConstants.OWNER_RESOURCE_TELEPHONE_EXAMPLE)
  private String telephone;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_EMAIL_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_EMAIL_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_EMAIL_MAX_LENGTH,
      required = true,
      pattern = OwnerConstants.OWNER_RESOURCE_EMAIL_PATTERN,
      example = OwnerConstants.OWNER_RESOURCE_EMAIL_EXAMPLE)
  private String email;

  @Schema(
      description = OwnerConstants.OWNER_RESOURCE_EMAIL_DESCRIPTION,
      minLength = OwnerConstants.OWNER_RESOURCE_EMAIL_MIN_LENGTH,
      maxLength = OwnerConstants.OWNER_RESOURCE_EMAIL_MAX_LENGTH,
      required = true,
      pattern = OwnerConstants.OWNER_RESOURCE_EMAIL_PATTERN,
      example = OwnerConstants.OWNER_RESOURCE_EMAIL_EXAMPLE)
  private LocalDate createAt;
}
