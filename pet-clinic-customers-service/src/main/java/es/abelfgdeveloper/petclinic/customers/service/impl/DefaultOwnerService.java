package es.abelfgdeveloper.petclinic.customers.service.impl;

import es.abelfgdeveloper.petclinic.customers.domain.Owner;
import es.abelfgdeveloper.petclinic.customers.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.mapper.OwnerMapper;
import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.customers.model.repository.OwnerRepository;
import es.abelfgdeveloper.petclinic.customers.model.specification.OwnerSpecification;
import es.abelfgdeveloper.petclinic.customers.service.OwnerService;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultOwnerService implements OwnerService {

  private final OwnerRepository ownerRepository;
  private final OwnerSpecification ownerSpecification;
  private final OwnerMapper ownerMapper;

  @Override
  public Owner create(Owner owner) {
    OwnerEntity ownerEntity = ownerMapper.mapDomainToEntity(owner);
    checkIfIdentificationDocumentExist(owner.getIdentificationDocument());
    return ownerMapper.mapEntityToDomain(ownerRepository.save(ownerEntity));
  }

  private void checkIfIdentificationDocumentExist(String identificationDocument) {
    Optional<OwnerEntity> findByIdentificationDocument =
        ownerRepository.findByIdentificationDocument(identificationDocument);
    if (findByIdentificationDocument.isPresent()) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_EXIST);
    }
  }

  @Override
  public Owner update(String id, Owner owner) {
    OwnerEntity ownerEntity = findOwnerNotDeleted(id);
    boolean isEdit = false;
    if (!ownerEntity.getFirstName().equals(owner.getFirstName())) {
      ownerEntity.setFirstName(owner.getFirstName());
      isEdit = true;
    }
    if (!ownerEntity.getLastName().equals(owner.getLastName())) {
      ownerEntity.setLastName(owner.getLastName());
      isEdit = true;
    }
    if (!ownerEntity.getEmail().equals(owner.getEmail())) {
      ownerEntity.setEmail(owner.getEmail());
      isEdit = true;
    }
    if (owner.getTelephone() != null && !owner.getTelephone().equals(ownerEntity.getTelephone())) {
      ownerEntity.setTelephone(owner.getTelephone());
      isEdit = true;
    }

    if (isEdit) {
      ownerEntity = ownerRepository.save(ownerEntity);
    }
    return ownerMapper.mapEntityToDomain(ownerRepository.save(ownerEntity));
  }

  @Override
  public void deleteById(String id) {
    OwnerEntity ownerEntity = findOwnerNotDeleted(id);
    ownerEntity.setDeleted(true);
    ownerRepository.save(ownerEntity);
  }

  @Override
  public Owner findById(String id) {
    return ownerMapper.mapEntityToDomain(findOwnerNotDeleted(id));
  }

  @Override
  public List<Owner> findAll() {
    return ownerRepository.findAll(ownerSpecification.notDeleted()).stream()
        .map(ownerMapper::mapEntityToDomain)
        .collect(Collectors.toList());
  }

  private OwnerEntity findOwnerNotDeleted(String id) {
    Optional<OwnerEntity> ownerEntity = ownerRepository.findById(id);
    if (!ownerEntity.isPresent()) {
      throw new BadRequestException(ErrorCodes.OWNER_ID_NOT_FOUND);
    }
    if (ownerEntity.get().isDeleted()) {
      throw new BadRequestException(ErrorCodes.OWNER_ID_NOT_FOUND);
    }
    return ownerEntity.get();
  }
}
