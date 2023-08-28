package photoshoot.backendworkspace.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//localhost:8080/swagger-ui/index.html
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi studioApi(){
        return GroupedOpenApi.builder()
                .group("studio-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi photographerApi(){
        return GroupedOpenApi.builder()
                .group("photographer-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi signApi(){
        return GroupedOpenApi.builder()
                .group("sign-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi memberApi(){
        return GroupedOpenApi.builder()
                .group("member-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi adminApi(){
        return GroupedOpenApi.builder()
                .group("admin-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public GroupedOpenApi utilApi(){
        return GroupedOpenApi.builder()
                .group("util-api")
                .pathsToMatch("/**")
                .build();
    }
    @Bean
    public OpenAPI pictainOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Pictain API Document")
                        .description("사진을 담다 api 명세서입니다")
                        .version("v0.0.1"));
    }
}
