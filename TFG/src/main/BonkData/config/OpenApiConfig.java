package BonkData.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Esta clase configura la documentación de la API usando OpenAPI (Swagger)
// y también habilita los repositorios JPA para la parte de gestión de productos.
@Configuration
@EnableJpaRepositories(basePackages = "BonkDAta.repositorio")
@OpenAPIDefinition(
        info = @Info(
                title = "BonkDAta",
                version = "1.0",
                description = "Documentación de la API de la wikipedia de Megabonk"
        )
)
public class OpenApiConfig { }