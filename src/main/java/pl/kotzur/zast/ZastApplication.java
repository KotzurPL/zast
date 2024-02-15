package pl.kotzur.zast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ZastApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZastApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/*").allowedOrigins("http://localhost:5173");
                corsRegistry.addMapping("/*/*").allowedOrigins("http://localhost:5173");
            }
        };
    }

}
