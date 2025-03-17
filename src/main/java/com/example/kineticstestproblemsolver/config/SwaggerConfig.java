package com.example.kineticstestproblemsolver.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Пример генерации OpenAPI из Spring MVC",
                version = "1.0.0"
        ),
        security = {
                @SecurityRequirement(name = "BearerAuth"),
                @SecurityRequirement(name = "keycloak-openid")
        }
)
@SecurityScheme(
        name = "BearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "JWT Bearer token for authorization"
)
@SecurityScheme(
        name = "keycloak-openid",
        type = SecuritySchemeType.OAUTH2,
        description = "Keycloak OpenID Connect (password, client_credentials) flows",
        flows = @OAuthFlows(
                password = @OAuthFlow(
                        tokenUrl = "http://keycloak:8080/realms/kinetics-app-realm/protocol/openid-connect/token"
                ),
                clientCredentials = @OAuthFlow(
                        tokenUrl = "http://keycloak:8080/realms/kinetics-app-realm/protocol/openid-connect/token"
                )
        )
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
}
