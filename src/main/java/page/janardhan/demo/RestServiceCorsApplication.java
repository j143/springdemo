package page.janardhan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The RESTful web service with Cross Origin Resource Sharing with
 * Spring.
 *
 * Based on https://spring.io/guides/gs/rest-service-cors/
 *
 * Usage: <code>./mvnw spring-boot:run -Dserver.port=9000</code>
 * or <code>./gradlew bootRun --args="--server.port=9000"</code>
 */

@SpringBootApplication
public class RestServiceCorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestServiceCorsApplication.class, args);
    }

    // add CORS mapping in the application class
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
            }
        };
    }
}

