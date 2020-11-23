package es.abelfgdeveloper.petclinic.customers.service.impl;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.common.exception.NotFoundException;
import es.abelfgdeveloper.petclinic.customers.domain.Owner;
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

  @Override
  public Owner update(String id, Owner owner) {
    OwnerEntity ownerEntity = findOwnerNotDeleted(id);
    ownerEntity.setFirstName(owner.getFirstName());
    ownerEntity.setLastName(owner.getLastName());
    ownerEntity.setEmail(owner.getEmail());
    ownerEntity.setTelephone(owner.getTelephone());
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

  private void checkIfIdentificationDocumentExist(String identificationDocument) {
    Optional<OwnerEntity> findByIdentificationDocument =
        ownerRepository.findByIdentificationDocument(identificationDocument);
    if (findByIdentificationDocument.isPresent()) {
      throw new BadRequestException(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_EXIST);
    }
  }

  private OwnerEntity findOwnerNotDeleted(String id) {
    Optional<OwnerEntity> ownerEntity = ownerRepository.findById(id);
    if (!ownerEntity.isPresent()) {
      throw new NotFoundException(ErrorCodes.OWNER_ID_NOT_FOUND);
    }
    if (ownerEntity.get().isDeleted()) {
      throw new NotFoundException(ErrorCodes.OWNER_ID_NOT_FOUND);
    }
    return ownerEntity.get();
  }
}
