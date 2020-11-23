package es.abelfgdeveloper.petclinic.customers.objectmother;

import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import java.time.LocalDateTime;

public class OwnerObjectMother {

  private OwnerObjectMother() {}

  public static OwnerEntity getOwnerEntity() {
    return OwnerEntity.builder()
        .id("ownerEntityId")
        .identificationDocument("11111111A")
        .firstName("ownerEntityFirstName")
        .lastName("ownerEntityLastName")
        .telephone("111111111")
        .email("ownerEntity@email.com")
        .auditCreateAt(LocalDateTime.now())
        .auditUpdateAt(LocalDateTime.now())
        .deleted(false)
        .build();
  }

  public static Owner getOwner() {
    return Owner.builder()
        .id("ownerId")
        .identificationDocument("11111111A")
        .firstName("ownerFirstName")
        .lastName("ownerLastName")
        .telephone("111111111")
        .email("owner@email.com")
        .auditCreateAt(LocalDateTime.now())
        .auditUpdateAt(LocalDateTime.now())
        .deleted(false)
        .build();
  }

  public static CreateOwnerRequestResource getCreateOwnerRequestResource() {
    return CreateOwnerRequestResource.builder()
        .identificationDocument("11111111A")
        .firstName("createOwnerFirstName")
        .lastName("createOwnerLastName")
        .telephone("111111111")
        .email("createOwnerRequest@email.com")
        .build();
  }

  public static UpdateOwnerRequestResource getUpdateOwnerRequestResource() {
    return UpdateOwnerRequestResource.builder()
        .firstName("updateOwnerFirstName")
        .lastName("updateOwnerLastName")
        .telephone("111111111")
        .email("updateOwnerRequest@email.com")
        .build();
  }
}
