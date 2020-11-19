package es.abelfgdeveloper.petclinic.customers.api.generic.resource;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "Recurso para devolver errores")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponseResource {

  @Schema(
      description = "Fecha y hora del error",
      required = true,
      example = "2020-10-22T13:43:22.370+00:00")
  private LocalDateTime timestamp;

  @Schema(description = "Codigo http del error", required = true, example = "500")
  private int status;

  @Schema(description = "Motivo del error", required = true, example = "Internal Server Error")
  private String error;

  @Schema(description = "Codigo de error", required = true, example = "25014")
  private String message;
}
