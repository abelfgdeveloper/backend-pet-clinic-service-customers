package es.abelfgdeveloper.petclinic.customers.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.customers.objectmother.OwnerObjectMother;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerMapperTest {

  private OwnerMapper ownerMapper;

  @BeforeEach
  public void setUp() {
    ownerMapper = new OwnerMapper();
  }

  @Test
  void test_mapResourceToDomain_createOwnerRequestResource_ok() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResource();

    // when
    Owner owner = ownerMapper.mapResourceToDomain(createOwnerRequestResource);

    // then
    assertNull(owner.getId(), "Id");
    assertEquals(
        createOwnerRequestResource.getIdentificationDocument(),
        owner.getIdentificationDocument(),
        "IdentificationDocument");
    assertEquals(createOwnerRequestResource.getFirstName(), owner.getFirstName(), "FirstName");
    assertEquals(createOwnerRequestResource.getLastName(), owner.getLastName(), "LastName");
    assertEquals(createOwnerRequestResource.getTelephone(), owner.getTelephone(), "Telephone");
    assertEquals(createOwnerRequestResource.getEmail(), owner.getEmail(), "Email");
    assertNull(owner.getAuditCreateAt(), "AuditCreateAt");
    assertNull(owner.getAuditUpdateAt(), "AuditUpdateAt");
    assertFalse(owner.isDeleted(), "isDeleted");
  }

  @Test
  void test_mapResourceToDomain_updateOwnerRequestResource_ok() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResource();

    // when
    Owner owner = ownerMapper.mapResourceToDomain(updateOwnerRequestResource);

    // then
    assertNull(owner.getId(), "Id");
    assertNull(owner.getIdentificationDocument(), "IdentificationDocument");
    assertEquals(updateOwnerRequestResource.getFirstName(), owner.getFirstName(), "FirstName");
    assertEquals(updateOwnerRequestResource.getLastName(), owner.getLastName(), "LastName");
    assertEquals(updateOwnerRequestResource.getTelephone(), owner.getTelephone(), "Telephone");
    assertEquals(updateOwnerRequestResource.getEmail(), owner.getEmail(), "Email");
    assertNull(owner.getAuditCreateAt(), "AuditCreateAt");
    assertNull(owner.getAuditUpdateAt(), "AuditUpdateAt");
    assertFalse(owner.isDeleted(), "isDeleted");
  }

  @Test
  void test_mapDomainToResource_ok() {
    // given
    Owner owner = OwnerObjectMother.getOwner();

    // when
    OwnerResponseResource ownerResponseResource = ownerMapper.mapDomainToResource(owner);

    // then
    assertEquals(owner.getId(), ownerResponseResource.getId(), "Id");
    assertEquals(
        owner.getIdentificationDocument(),
        ownerResponseResource.getIdentificationDocument(),
        "IdentificationDocument");
    assertEquals(owner.getFirstName(), ownerResponseResource.getFirstName(), "FirstName");
    assertEquals(owner.getLastName(), ownerResponseResource.getLastName(), "LastName");
    assertEquals(owner.getTelephone(), ownerResponseResource.getTelephone(), "Telephone");
    assertEquals(owner.getEmail(), ownerResponseResource.getEmail(), "Email");
    assertEquals(
        owner.getAuditCreateAt().toLocalDate(),
        ownerResponseResource.getCreateAt(),
        "AuditCreateAt");
  }

  @Test
  void test_mapDomainToResource_list_ok() {
    // given
    List<Owner> owners = new ArrayList<>();
    owners.add(OwnerObjectMother.getOwner());

    // when
    List<OwnerResponseResource> ownersResponseResource = ownerMapper.mapDomainToResource(owners);

    // then
    assertEquals(owners.get(0).getId(), ownersResponseResource.get(0).getId(), "Id");
    assertEquals(
        owners.get(0).getIdentificationDocument(),
        ownersResponseResource.get(0).getIdentificationDocument(),
        "IdentificationDocument");
    assertEquals(
        owners.get(0).getFirstName(), ownersResponseResource.get(0).getFirstName(), "FirstName");
    assertEquals(
        owners.get(0).getLastName(), ownersResponseResource.get(0).getLastName(), "LastName");
    assertEquals(
        owners.get(0).getTelephone(), ownersResponseResource.get(0).getTelephone(), "Telephone");
    assertEquals(owners.get(0).getEmail(), ownersResponseResource.get(0).getEmail(), "Email");
    assertEquals(
        owners.get(0).getAuditCreateAt().toLocalDate(),
        ownersResponseResource.get(0).getCreateAt(),
        "AuditCreateAt");
  }

  @Test
  void test_mapDomainToEntity_ok() {
    // given
    Owner owner = OwnerObjectMother.getOwner();

    // when
    OwnerEntity ownerEntity = ownerMapper.mapDomainToEntity(owner);

    // then
    assertNull(ownerEntity.getId(), "Id");
    assertEquals(
        owner.getIdentificationDocument(),
        ownerEntity.getIdentificationDocument(),
        "IdentificationDocument");
    assertEquals(owner.getFirstName(), ownerEntity.getFirstName(), "FirstName");
    assertEquals(owner.getLastName(), ownerEntity.getLastName(), "LastName");
    assertEquals(owner.getTelephone(), ownerEntity.getTelephone(), "Telephone");
    assertEquals(owner.getEmail(), ownerEntity.getEmail(), "Email");
    assertNull(ownerEntity.getAuditCreateAt(), "AuditCreateAt");
    assertNull(ownerEntity.getAuditUpdateAt(), "AuditUpdateAt");
    assertFalse(ownerEntity.isDeleted(), "isDeleted");
  }

  @Test
  void test_mapEntityToDomain_ok() {
    // given
    OwnerEntity ownerEntity = OwnerObjectMother.getOwnerEntity();

    // when
    Owner owner = ownerMapper.mapEntityToDomain(ownerEntity);

    // then
    assertEquals(ownerEntity.getId(), owner.getId(), "Id");
    assertEquals(
        ownerEntity.getIdentificationDocument(),
        owner.getIdentificationDocument(),
        "IdentificationDocument");
    assertEquals(ownerEntity.getFirstName(), owner.getFirstName(), "FirstName");
    assertEquals(ownerEntity.getLastName(), owner.getLastName(), "LastName");
    assertEquals(ownerEntity.getTelephone(), owner.getTelephone(), "Telephone");
    assertEquals(ownerEntity.getEmail(), owner.getEmail(), "Email");
    assertEquals(ownerEntity.getAuditCreateAt(), owner.getAuditCreateAt(), "AuditCreateAt");
    assertEquals(ownerEntity.getAuditUpdateAt(), owner.getAuditUpdateAt(), "AuditUpdateAt");
    assertFalse(owner.isDeleted(), "isDeleted");
  }
}
