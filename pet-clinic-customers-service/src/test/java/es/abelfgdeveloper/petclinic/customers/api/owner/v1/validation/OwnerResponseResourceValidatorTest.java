package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.abelfgdeveloper.common.exception.InternalServerException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerResponseResourceValidatorTest {

  private OwnerResponseResourceValidator ownerResponseResourceValidator;

  @BeforeEach
  public void setUp() {
    ownerResponseResourceValidator = new OwnerResponseResourceValidator();
  }

  @Test
  void test_validate_ko_objectNull() {
    // given
    OwnerResponseResource ownerResponseResource = null;

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_RESPONSE_RESOURCE_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_idNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_ID_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentMinLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentMaxLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument("1111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_identificationDocumentPattern() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument("111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_IDENTIFICATION_DOCUMENT_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMinLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMaxLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName("abcdefghijklmnopqrstuvwxyz");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMinLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMaxLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName("abcdefghijklmnopqrstuvwxyz");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMinLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMaxLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone("1111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephonePattern() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone("AAAAAAAAA");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail(null);

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMinLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMaxLength() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail("aaaaabbbbbcccccdddddeeeee@test.com");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailPattern() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail("aaaaabbbbb");

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_createAtNull() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail(getValidEmail());

    // when
    Throwable exception =
        Assertions.assertThrows(
            InternalServerException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_CREATE_AT_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    OwnerResponseResource ownerResponseResource = new OwnerResponseResource();
    ownerResponseResource.setId(getValidId());
    ownerResponseResource.setIdentificationDocument(getValidIdentificationDocument());
    ownerResponseResource.setFirstName(getValidFirstName());
    ownerResponseResource.setLastName(getValidLastName());
    ownerResponseResource.setTelephone(getValidTelephone());
    ownerResponseResource.setEmail(getValidEmail());
    ownerResponseResource.setCreateAt(getValidCreateAt());

    // when
    ownerResponseResourceValidator.validate(ownerResponseResource);

    // then
  }

  private String getValidId() {
    return "aaaaa-bbbb-ccccc-ddddd";
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

  private LocalDate getValidCreateAt() {
    return LocalDate.now();
  }
}
