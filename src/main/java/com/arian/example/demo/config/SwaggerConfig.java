package com.arian.example.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

   @Bean
   public GroupedOpenApi publicApi() {
      return GroupedOpenApi.builder().group("public").pathsToMatch("/calculator/**").build();
   }

   @Bean
   public OpenAPI customOpenAPI() {
      return new OpenAPI()
            .info(new Info()
                  .title("SOAP Calculator API")
                  .description("Calculator API Documentation")
                  .version("1.0.0")
                  .contact(new Contact().name("John").email("john.doe@example.arian.com").url("https://www.johndoe.com"))
                  .license(new License().name("Licencia Apache 2.0").url("http://springdoc.org")))
            .externalDocs(new ExternalDocumentation().description("Documentación Externa").url("https://www.johndoe.com/documentacion"));
   }

}
