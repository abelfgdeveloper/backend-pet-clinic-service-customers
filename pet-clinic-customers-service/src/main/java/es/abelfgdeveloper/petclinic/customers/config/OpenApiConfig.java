package es.abelfgdeveloper.petclinic.customers.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Value("${es.abelfgdeveloper.api.title}")
  private String title;

  @Value("${es.abelfgdeveloper.api.description}")
  private String description;

  @Value("${es.abelfgdeveloper.api.version}")
  private String version;

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info().title(title).description(description).version(version))
        .components(new Components());
  }
}
