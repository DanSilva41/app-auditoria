package br.com.silva.app.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())

                .info(new Info()
                        .title("POC - App Auditoria")
                        .description("Aplicação demonstrativa de Spring Boot com Hibernate Envers - Auditoria")
                        .version("1.0.0-SNAPSHOT")
                        .termsOfService("Terms of service")
                        .contact(new Contact()
                                .name("Danilo Silva")
                                .email("danilosilvap@outlook.com.br")
                                .url("https://dansilva41.github.io/"))
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
