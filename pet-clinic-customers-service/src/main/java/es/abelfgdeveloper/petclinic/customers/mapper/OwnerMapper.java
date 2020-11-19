package es.abelfgdeveloper.petclinic.customers.mapper;

import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

  public Owner mapResourceToDomain(CreateOwnerRequestResource owner) {
    return Owner.builder()
        .identificationDocument(owner.getIdentificationDocument())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .telephone(owner.getTelephone())
        .email(owner.getEmail())
        .build();
  }

  public Owner mapResourceToDomain(UpdateOwnerRequestResource owner) {
    return Owner.builder()
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .telephone(owner.getTelephone())
        .email(owner.getEmail())
        .build();
  }

  public List<OwnerResponseResource> mapDomainToResource(List<Owner> owners) {
    return owners.stream().map(this::mapDomainToResource).collect(Collectors.toList());
  }

  public OwnerResponseResource mapDomainToResource(Owner owner) {
    return OwnerResponseResource.builder()
        .id(owner.getId())
        .identificationDocument(owner.getIdentificationDocument())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .telephone(owner.getTelephone())
        .email(owner.getEmail())
        .createAt(owner.getAuditCreateAt().toLocalDate())
        .build();
  }

  public OwnerEntity mapDomainToEntity(Owner owner) {
    return OwnerEntity.builder()
        .identificationDocument(owner.getIdentificationDocument())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .telephone(owner.getTelephone())
        .email(owner.getEmail())
        .build();
  }

  public Owner mapEntityToDomain(OwnerEntity owner) {
    return Owner.builder()
        .id(owner.getId())
        .identificationDocument(owner.getIdentificationDocument())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .telephone(owner.getTelephone())
        .email(owner.getEmail())
        .auditCreateAt(owner.getAuditCreateAt())
        .auditUpdateAt(owner.getAuditUpdateAt())
        .deleted(owner.isDeleted())
        .build();
  }
}
