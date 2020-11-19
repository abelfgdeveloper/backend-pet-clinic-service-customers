package es.abelfgdeveloper.petclinic.customers.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbelfgDeveloperException {

  private static final long serialVersionUID = 1L;

  private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

  public NotFoundException() {
    super(STATUS);
  }

  public NotFoundException(String message, Throwable cause) {
    super(STATUS, message, cause);
  }

  public NotFoundException(String message) {
    super(STATUS, message);
  }

  public NotFoundException(Throwable cause) {
    super(STATUS, cause);
  }
}
