package es.abelfgdeveloper.petclinic.customers.api.owner.v1;

import es.abelfgdeveloper.common.resource.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerListResponseResource;
import es.abelfgdeveloper.petclinic.customers.api.owner.v1.resource.response.OwnerResponseResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "owners", description = "Operaciones con dueños de mascotas")
@RequestMapping("/v1/owners")
public interface OwnerApi {

  @Operation(
      summary = "Crear un nuevo dueño",
      description = "Crea un nuevo dueño en el sistema",
      tags = {"owners"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Dueño creado correctamente",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OwnerResponseResource.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class)))
      })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  OwnerResponseResource create(@RequestBody CreateOwnerRequestResource request);

  @Operation(
      summary = "Actualiza un dueño existente en el sistema",
      description = "Actualiza un dueño existente en el sistema",
      tags = {"owners"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Dueño actualizado correctamente",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OwnerResponseResource.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Not Found",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class)))
      })
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  OwnerResponseResource update(
      @PathVariable("id") String id, @RequestBody UpdateOwnerRequestResource request);

  @Operation(
      summary = "Borrado logico de un dueño por ID existente en el sistema",
      description = "Borrado logico de un dueño por ID existente en el sistema",
      tags = {"owners"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "204",
            description = "Dueño borrado correctamente",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OwnerResponseResource.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Not Found",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class)))
      })
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable("id") String id);

  @Operation(
      summary = "Busca un dueño por ID en el sistema",
      description = "Busca un dueño por ID en el sistema",
      tags = {"owners"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Dueño encontrado",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OwnerResponseResource.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Not Found",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class)))
      })
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  OwnerResponseResource findById(@PathVariable("id") String id);

  @Operation(
      summary = "Busca todos los dueños del sistema",
      description = "Busca todos los dueños del sistema",
      tags = {"owners"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Listado de dueños",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = OwnerListResponseResource.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal Server Error",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponseResource.class)))
      })
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  OwnerListResponseResource findAll();
}
