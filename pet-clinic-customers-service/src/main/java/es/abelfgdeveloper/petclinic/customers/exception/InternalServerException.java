package es.abelfgdeveloper.petclinic.customers.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

  public InternalServerException() {
    super(STATUS);
  }

  public InternalServerException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }

  public InternalServerException(String message) {
    super(STATUS, message);
  }

  public InternalServerException(Throwable cause) {
    super(STATUS, cause);
  }
}
