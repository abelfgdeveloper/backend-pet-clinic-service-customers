package es.abelfgdeveloper.petclinic.customers.api.owner.v1.controller;

import es.abelfgdeveloper.petclinic.customers.api.owner.v1.OwnerApi;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerListResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation.CreateOwnerRequestResourceValidator;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation.OwnerListResponseResourceValidator;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation.OwnerResponseResourceValidator;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation.UpdateOwnerRequestResourceValidator;
import es.abelfgdeveloper.petclinic.customers.mapper.OwnerMapper;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.CreateOwnerUseCase;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.DeleteOwnerByIdUseCase;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.FindAllOwnersUseCase;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.FindOwnerByIdUseCase;
import es.abelfgdeveloper.petclinic.customers.usecase.owner.UpdateOwnerUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OwnerController implements OwnerApi {

  // Use Cases
  private final CreateOwnerUseCase createOwnerUseCase;
  private final UpdateOwnerUseCase updateOwnerUseCase;
  private final DeleteOwnerByIdUseCase deleteOwnerByIdUseCase;
  private final FindOwnerByIdUseCase findOwnerByIdUseCase;
  private final FindAllOwnersUseCase findAllOwnersUseCase;

  // Validators
  private final CreateOwnerRequestResourceValidator createOwnerRequestResourceValidator;
  private final UpdateOwnerRequestResourceValidator updateOwnerRequestResourceValidator;
  private final OwnerResponseResourceValidator ownerResponseResourceValidator;
  private final OwnerListResponseResourceValidator ownerListResponseResourceValidator;

  // Mappers
  private final OwnerMapper ownerMapper;

  @Override
  public OwnerResponseResource create(CreateOwnerRequestResource request) {
    createOwnerRequestResourceValidator.validate(request);
    OwnerResponseResource response =
        ownerMapper.mapDomainToResource(
            createOwnerUseCase.execute(ownerMapper.mapResourceToDomain(request)));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public OwnerResponseResource update(String id, UpdateOwnerRequestResource request) {
    updateOwnerRequestResourceValidator.validate(request);
    OwnerResponseResource response =
        ownerMapper.mapDomainToResource(
            updateOwnerUseCase.execute(id, ownerMapper.mapResourceToDomain(request)));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public void deleteById(String id) {
    deleteOwnerByIdUseCase.execute(id);
  }

  @Override
  public OwnerResponseResource findById(String id) {
    OwnerResponseResource response =
        ownerMapper.mapDomainToResource(findOwnerByIdUseCase.execute(id));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public OwnerListResponseResource findAll() {
    List<OwnerResponseResource> response =
        ownerMapper.mapDomainToResource(findAllOwnersUseCase.execute());
    ownerListResponseResourceValidator.validate(response);
    return OwnerListResponseResource.builder().owners(response).build();
  }
}
