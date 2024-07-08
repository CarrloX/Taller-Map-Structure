package com.riwi.workshop.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API RestLibreria", version = "1.0", description = "Documentacion de la API Rest Libreria"))
public class OpenApiConfig {

}