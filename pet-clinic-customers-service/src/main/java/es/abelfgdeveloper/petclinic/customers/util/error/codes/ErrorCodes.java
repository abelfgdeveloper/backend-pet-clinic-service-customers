package es.abelfgdeveloper.petclinic.customers.util.error.codes;

public class ErrorCodes {

  // Owner
  public static final String CREATE_OWNER_REQUEST_RESOURCE_NOT_NULL = "1";
  public static final String UPDATE_OWNER_REQUEST_RESOURCE_NOT_NULL = "2";
  public static final String OWNER_RESPONSE_RESOURCE_NOT_NULL = "2";

  // Owner - Id
  public static final String OWNER_ID_NOT_NULL = "3";
  public static final String OWNER_ID_NOT_FOUND = "4";

  // Owner - Identification Document
  public static final String OWNER_IDENTIFICATION_DOCUMENT_NOT_NULL = "5";
  public static final String OWNER_IDENTIFICATION_DOCUMENT_LENGTH = "6";
  public static final String OWNER_IDENTIFICATION_DOCUMENT_PATTERN = "7";
  public static final String OWNER_IDENTIFICATION_DOCUMENT_EXIST = "8";

  // Owner - First Name
  public static final String OWNER_FIRST_NAME_NOT_NULL = "9";
  public static final String OWNER_FIRST_NAME_LENGTH = "10";

  // Owner - Last Name
  public static final String OWNER_LAST_NAME_NOT_NULL = "11";
  public static final String OWNER_LAST_NAME_LENGTH = "12";

  // Owner - Telephone
  public static final String OWNER_TELEPHONE_LENGTH = "13";
  public static final String OWNER_TELEPHONE_PATTERN = "14";

  // Owner - Email
  public static final String OWNER_EMAIL_NOT_NULL = "15";
  public static final String OWNER_EMAIL_LENGTH = "16";
  public static final String OWNER_EMAIL_PATTERN = "17";

  // Owner - Create At
  public static final String OWNER_CREATE_AT_NOT_NULL = "18";
}
