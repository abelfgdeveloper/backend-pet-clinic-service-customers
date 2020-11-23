package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateOwnerRequestResourceValidatorTest {

  private CreateOwnerRequestResourceValidator createOwnerRequestResourceValidator;

  @BeforeEach
  public void setUp() {
    createOwnerRequestResourceValidator = new CreateOwnerRequestResourceValidator();
  }

  @Test
  void test_validate_ko_objectNull() {
    // given
    CreateOwnerRequestResource CreateOwnerRequestResource = null;

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(CreateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.CREATE_OWNER_REQUEST_RESOURCE_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentNull() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentMinLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentMaxLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument("1111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentPattern() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument("111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameNull() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMinLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMaxLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName("abcdefghijklmnopqrstuvwxyz");
    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameNull() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMinLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMaxLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName("abcdefghijklmnopqrstuvwxyz");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMinLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMaxLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone("1111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephonePattern() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone("AAAAAAAAA");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailNull() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone(getValidTelephone());
    createOwnerRequestResource.setEmail(null);

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMinLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone(getValidTelephone());
    createOwnerRequestResource.setEmail("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMaxLength() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone(getValidTelephone());
    createOwnerRequestResource.setEmail("aaaaabbbbbcccccdddddeeeee@test.com");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailPattern() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone(getValidTelephone());
    createOwnerRequestResource.setEmail("aaaaabbbbb");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = new CreateOwnerRequestResource();
    createOwnerRequestResource.setIdentificationDocument(getValidIdentificationDocument());
    createOwnerRequestResource.setFirstName(getValidFirstName());
    createOwnerRequestResource.setLastName(getValidLastName());
    createOwnerRequestResource.setTelephone(getValidTelephone());
    createOwnerRequestResource.setEmail(getValidEmail());

    // when
    createOwnerRequestResourceValidator.validate(createOwnerRequestResource);

    // then
  }

  private String getValidIdentificationDocument() {
    return "11111111A";
  }

  private String getValidFirstName() {
    return "FirstName";
  }

  private String getValidLastName() {
    return "LastName";
  }

  private String getValidTelephone() {
    return "111111111";
  }

  private String getValidEmail() {
    return "mail@test.com";
  }
}
