package ru.skillbox.mvc.mvc7;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
        title = "Новостной API",
        version = "1.0",
        description = "API для работы с новостями"
    )
)
@SpringBootApplication
public class Mvc7Application {

	public static void main(String[] args) {
		SpringApplication.run(Mvc7Application.class, args);
	}

}
