package es.abelfgdeveloper.petclinic.customers.config;

import es.abelfgdeveloper.petclinic.customers.api.generic.resource.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.customers.exception.AbelfgDeveloperException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(AbelfgDeveloperException.class)
  public ResponseEntity<ErrorResponseResource> handleAccessDeniedException(
      AbelfgDeveloperException ex, WebRequest request) {
    if (ex.getStatus().is5xxServerError()) {
      log.error("Exception: {}", ex);
    } else {
      log.warn("Exception: {}", ex);
    }
    return new ResponseEntity<>(
        generateErrorResponseResource(ex), new HttpHeaders(), ex.getStatus());
  }

  private ErrorResponseResource generateErrorResponseResource(AbelfgDeveloperException ex) {
    return ErrorResponseResource.builder()
        .timestamp(LocalDateTime.now())
        .status(ex.getStatus().value())
        .error(ex.getStatus().getReasonPhrase())
        .message(ex.getMessage())
        .build();
  }
}
