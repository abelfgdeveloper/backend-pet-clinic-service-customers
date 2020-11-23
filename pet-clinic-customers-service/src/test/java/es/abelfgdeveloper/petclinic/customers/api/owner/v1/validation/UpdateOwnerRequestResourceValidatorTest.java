package es.abelfgdeveloper.petclinic.customers.api.owner.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.abelfgdeveloper.common.exception.BadRequestException;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.util.error.codes.ErrorCodes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateOwnerRequestResourceValidatorTest {

  private UpdateOwnerRequestResourceValidator updateOwnerRequestResourceValidator;

  @BeforeEach
  public void setUp() {
    updateOwnerRequestResourceValidator = new UpdateOwnerRequestResourceValidator();
  }

  @Test
  void test_validate_ko_objectNull() {
    // given
    UpdateOwnerRequestResource CreateOwnerRequestResource = null;

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(CreateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.UPDATE_OWNER_REQUEST_RESOURCE_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameNull() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMinLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_firstNameMaxLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName("abcdefghijklmnopqrstuvwxyz");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_FIRST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameNull() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMinLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_lastNameMaxLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName("abcdefghijklmnopqrstuvwxyz");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_LAST_NAME_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMinLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephoneMaxLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone("1111111111");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_telephonePattern() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone("AAAAAAAAA");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_TELEPHONE_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailNull() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone(getValidTelephone());
    updateOwnerRequestResource.setEmail(null);

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_NOT_NULL, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMinLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone(getValidTelephone());
    updateOwnerRequestResource.setEmail("");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailMaxLength() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone(getValidTelephone());
    updateOwnerRequestResource.setEmail("aaaaabbbbbcccccdddddeeeee@test.com");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_LENGTH, exception.getMessage());
  }

  @Test
  void test_validate_ko_emailPattern() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone(getValidTelephone());
    updateOwnerRequestResource.setEmail("aaaaabbbbb");

    // when
    Throwable exception =
        Assertions.assertThrows(
            BadRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(ErrorCodes.OWNER_EMAIL_PATTERN, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = new UpdateOwnerRequestResource();
    updateOwnerRequestResource.setFirstName(getValidFirstName());
    updateOwnerRequestResource.setLastName(getValidLastName());
    updateOwnerRequestResource.setTelephone(getValidTelephone());
    updateOwnerRequestResource.setEmail(getValidEmail());

    // when
    updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);

    // then
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
