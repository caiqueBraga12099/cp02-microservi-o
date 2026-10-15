package com.github.caiqueBraga12099.registrometeorologico.config;

import org.springframework.context.annotation.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI().info(new Info().title("API de Registros Meteorológicos")
                .version("1.0.0").description("Checkpoint 2 — Caique — RM 555532"));
    }
}
