package es.abelfgdeveloper.petclinic.customers.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbelfgDeveloperException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final HttpStatus status;

  public AbelfgDeveloperException(HttpStatus status) {
    super();
    this.status = status;
  }

  public AbelfgDeveloperException(HttpStatus status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
  }

  public AbelfgDeveloperException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }

  public AbelfgDeveloperException(HttpStatus status, Throwable cause) {
    super(cause);
    this.status = status;
  }
}
