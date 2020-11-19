package es.abelfgdeveloper.petclinic.customers.api.owner;

public class OwnerConstants {

  private OwnerConstants() {}

  public static final String CREATE_OWNER_REQUEST_RESOURCE_DESCRIPTION =
      "Recurso para gestionar un dueño";
  public static final String UPDATE_OWNER_REQUEST_RESOURCE_DESCRIPTION =
      "Recurso para actualiza un dueño";
  public static final String OWNER_RESPONSE_RESOURCE_DESCRIPTION =
      "Recurso para mostrar los datos de un dueño";

  // ID
  public static final String OWNER_RESOURCE_ID_DESCRIPTION =
      "Identificador del dueño en el sistema";
  public static final String OWNER_RESOURCE_ID_EXAMPLE = "123a6999-f457-44cd-baa0-58ba7f3e5875";

  // Identification Document
  public static final String OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_DESCRIPTION =
      "Documento de identificacion del dueño (DNI)";
  public static final int OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MIN_LENGTH = 9;
  public static final int OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_MAX_LENGTH = 9;
  public static final String OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_PATTERN =
      "^\\d{8}[A-HJ-NP-TV-Z]$";
  public static final String OWNER_RESOURCE_IDENTIFICATION_DOCUMENT_EXAMPLE = "65475943A";

  // First Name
  public static final String OWNER_RESOURCE_FIRST_NAME_DESCRIPTION = "Nombre del dueño";
  public static final int OWNER_RESOURCE_FIRST_NAME_MIN_LENGTH = 3;
  public static final int OWNER_RESOURCE_FIRST_NAME_MAX_LENGTH = 25;
  public static final String OWNER_RESOURCE_FIRST_NAME_EXAMPLE = "Frodo";

  // Last Name
  public static final String OWNER_RESOURCE_LAST_NAME_DESCRIPTION = "Apellido del dueño";
  public static final int OWNER_RESOURCE_LAST_NAME_MIN_LENGTH = 3;
  public static final int OWNER_RESOURCE_LAST_NAME_MAX_LENGTH = 25;
  public static final String OWNER_RESOURCE_LAST_NAME_EXAMPLE = "Bolson";

  // Telephone
  public static final String OWNER_RESOURCE_TELEPHONE_DESCRIPTION = "Telefono del dueño";
  public static final int OWNER_RESOURCE_TELEPHONE_MIN_LENGTH = 9;
  public static final int OWNER_RESOURCE_TELEPHONE_MAX_LENGTH = 9;
  public static final String OWNER_RESOURCE_TELEPHONE_PATTERN = "\\d{9}$";
  public static final String OWNER_RESOURCE_TELEPHONE_EXAMPLE = "666666666";

  // Email
  public static final String OWNER_RESOURCE_EMAIL_DESCRIPTION = "Email del dueño";
  public static final int OWNER_RESOURCE_EMAIL_MIN_LENGTH = 5;
  public static final int OWNER_RESOURCE_EMAIL_MAX_LENGTH = 30;
  public static final String OWNER_RESOURCE_EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
  public static final String OWNER_RESOURCE_EMAIL_EXAMPLE = "test@gmail.com";

  // Audit Create At
  public static final String OWNER_RESOURCE_AUDIT_CREATE_AT_DESCRIPTION = "Email del dueño";
  public static final String OWNER_RESOURCE_AUDIT_CREATE_AT_EXAMPLE = "2020-19-11";
}
