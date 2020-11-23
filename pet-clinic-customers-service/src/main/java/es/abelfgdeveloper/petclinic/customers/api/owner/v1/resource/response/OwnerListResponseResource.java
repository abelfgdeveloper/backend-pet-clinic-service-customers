package es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response;

import es.abelfgdeveloper.petclinic.customers.api.owner.OwnerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = OwnerConstants.OWNER_LIST_RESPONSE_RESOURCE_DESCRIPTION)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OwnerListResponseResource {

  @Schema(description = OwnerConstants.OWNER_LIST_DESCRIPTION, required = true)
  private List<OwnerResponseResource> owners;
}
