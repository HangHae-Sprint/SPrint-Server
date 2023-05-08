
package com.example.sprintserver.common.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Sprint API Document",
                    description = "Api document for SPRINT PROJECT",
                    version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi sprintOpenApi() {
        String[] paths = {"/**"};
        return GroupedOpenApi.builder()
                .group("SPRINT API v1")
                .pathsToMatch(paths)
                .build();
    }
}

