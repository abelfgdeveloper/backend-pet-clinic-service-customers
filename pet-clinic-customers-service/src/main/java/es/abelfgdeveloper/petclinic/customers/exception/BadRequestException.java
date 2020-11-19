package es.abelfgdeveloper.petclinic.customers.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;

  public BadRequestException() {
    super(STATUS);
  }

  public BadRequestException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }

  public BadRequestException(String message) {
    super(STATUS, message);
  }

  public BadRequestException(Throwable cause) {
    super(STATUS, cause);
  }
}
