package es.abelfgdeveloper.petclinic.customers.api.owner.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import es.abelfgdeveloper.common.resource.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.CommonApiTest;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerListResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.customers.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class OwnerApiTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/owners";

  @Test
  void test_create_ok() throws Exception {
    // given
    cleanDataBase();
    CreateOwnerRequestResource request = OwnerObjectMother.getCreateOwnerRequestResource();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(BASE_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.CREATED, responseStatus);
    assertNotNull(response.getId());
    assertEquals(request.getIdentificationDocument(), response.getIdentificationDocument());
    assertEquals(request.getFirstName(), response.getFirstName());
    assertEquals(request.getLastName(), response.getLastName());
    assertEquals(request.getEmail(), response.getEmail());
    assertEquals(request.getTelephone(), response.getTelephone());
    assertNotNull(response.getCreateAt());

    // then validate the database
    OwnerEntity ownerEntity = ownerRepository.findById(response.getId()).get();
    assertNotNull(ownerEntity.getId());
    assertEquals(request.getIdentificationDocument(), ownerEntity.getIdentificationDocument());
    assertEquals(request.getFirstName(), ownerEntity.getFirstName());
    assertEquals(request.getLastName(), ownerEntity.getLastName());
    assertEquals(request.getTelephone(), ownerEntity.getTelephone());
    assertEquals(request.getEmail(), ownerEntity.getEmail());
    assertNotNull(ownerEntity.getAuditCreateAt());
    assertNotNull(ownerEntity.getAuditUpdateAt());
    assertFalse(ownerEntity.isDeleted());
  }

  @Test
  void test_create_ko_identificationDocumentExist() throws Exception {
    // given
    cleanDataBase();
    OwnerEntity ownerSaved = OwnerObjectMother.getOwnerEntity();
    ownerRepository.save(ownerSaved);
    CreateOwnerRequestResource request = OwnerObjectMother.getCreateOwnerRequestResource();
    request.setIdentificationDocument(ownerSaved.getIdentificationDocument());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(BASE_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    ErrorResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), ErrorResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.BAD_REQUEST, responseStatus);
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_EXIST, response.getMessage());
  }

  @Test
  void test_update_ok() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT + "/{id}";
    cleanDataBase();
    OwnerEntity ownerSave = ownerRepository.save(OwnerObjectMother.getOwnerEntity());
    UpdateOwnerRequestResource request = OwnerObjectMother.getUpdateOwnerRequestResource();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put(endpoint, ownerSave.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertNotNull(response.getId());
    assertNotNull(response.getIdentificationDocument());
    assertEquals(request.getFirstName(), response.getFirstName());
    assertEquals(request.getLastName(), response.getLastName());
    assertEquals(request.getEmail(), response.getEmail());
    assertEquals(request.getTelephone(), response.getTelephone());
    assertNotNull(response.getCreateAt());

    // then validate the database
    OwnerEntity ownerEntity = ownerRepository.findById(response.getId()).get();
    assertNotNull(ownerEntity.getId());
    assertNotNull(ownerEntity.getIdentificationDocument());
    assertEquals(request.getFirstName(), ownerEntity.getFirstName());
    assertEquals(request.getLastName(), ownerEntity.getLastName());
    assertEquals(request.getTelephone(), ownerEntity.getTelephone());
    assertEquals(request.getEmail(), ownerEntity.getEmail());
    assertNotNull(ownerEntity.getAuditCreateAt());
    assertNotNull(ownerEntity.getAuditUpdateAt());
    assertFalse(ownerEntity.isDeleted());
  }

  @Test
  void test_delete_ok() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT + "/{id}";
    cleanDataBase();
    OwnerEntity ownerSave = ownerRepository.save(OwnerObjectMother.getOwnerEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(endpoint, ownerSave.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());

    // then validate the response
    assertEquals(HttpStatus.NO_CONTENT, responseStatus);

    // then validate the database
    OwnerEntity ownerEntity = ownerRepository.findById(ownerSave.getId()).get();
    assertTrue(ownerEntity.isDeleted());
  }

  @Test
  void test_findById_ok() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT + "/{id}";
    cleanDataBase();
    OwnerEntity ownerSave = ownerRepository.save(OwnerObjectMother.getOwnerEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(endpoint, ownerSave.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(ownerSave.getId(), response.getId());
    assertEquals(ownerSave.getIdentificationDocument(), response.getIdentificationDocument());
    assertEquals(ownerSave.getFirstName(), response.getFirstName());
    assertEquals(ownerSave.getLastName(), response.getLastName());
    assertEquals(ownerSave.getEmail(), response.getEmail());
    assertEquals(ownerSave.getTelephone(), response.getTelephone());
    assertEquals(ownerSave.getAuditCreateAt().toLocalDate(), response.getCreateAt());
  }

  @Test
  void test_findById_ko_notFound() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT + "/{id}";
    cleanDataBase();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(endpoint, "1")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    ErrorResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), ErrorResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.NOT_FOUND, responseStatus);
    assertEquals(ErrorCodes.OWNER_ID_NOT_FOUND, response.getMessage());
  }

  @Test
  void test_findById_ko_ownerDeleted() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT + "/{id}";
    cleanDataBase();
    OwnerEntity ownerSave = OwnerObjectMother.getOwnerEntity();
    ownerSave.setDeleted(true);
    ownerSave = ownerRepository.save(ownerSave);

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(endpoint, ownerSave.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    ErrorResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), ErrorResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.NOT_FOUND, responseStatus);
    assertEquals(ErrorCodes.OWNER_ID_NOT_FOUND, response.getMessage());
  }

  @Test
  void test_findAll_ok() throws Exception {
    // given
    String endpoint = BASE_ENDPOINT;
    cleanDataBase();
    OwnerEntity ownerSave = ownerRepository.save(OwnerObjectMother.getOwnerEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(endpoint, ownerSave.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerListResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerListResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(1, response.getOwners().size());
    assertEquals(ownerSave.getId(), response.getOwners().get(0).getId());
    assertEquals(
        ownerSave.getIdentificationDocument(),
        response.getOwners().get(0).getIdentificationDocument());
    assertEquals(ownerSave.getFirstName(), response.getOwners().get(0).getFirstName());
    assertEquals(ownerSave.getLastName(), response.getOwners().get(0).getLastName());
    assertEquals(ownerSave.getEmail(), response.getOwners().get(0).getEmail());
    assertEquals(ownerSave.getTelephone(), response.getOwners().get(0).getTelephone());
    assertEquals(
        ownerSave.getAuditCreateAt().toLocalDate(), response.getOwners().get(0).getCreateAt());
  }
}
