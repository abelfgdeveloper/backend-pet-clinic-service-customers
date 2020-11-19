package es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request;

import es.abelfgdeveloper.petclinic.customers.api.owner.OwnerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = OwnerConstants.UPDATE_OWNER_REQUEST_RESOURCE_DESCRIPTION)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateOwnerRequestResource {

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
}
