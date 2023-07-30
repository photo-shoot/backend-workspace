//package photoshoot.backendworkspace.config;
//
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Swagger2Config {
//    @Bean
//    public GroupedOpenApi publicApi() {
//        return GroupedOpenApi.builder()
//                .group("public")
//                .pathsToMatch("/public/**")
//                .group("member")
//                .pathsToMatch("/member/**")
//                .group("member")
//                .pathsToMatch("/member/**")
//                .build();
//    }
//
//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("Pictain API")
//                        .description("Pictain 프로젝트 API 명세서입니다.")
//                        .version("v0.0.1");
//    }
//}
