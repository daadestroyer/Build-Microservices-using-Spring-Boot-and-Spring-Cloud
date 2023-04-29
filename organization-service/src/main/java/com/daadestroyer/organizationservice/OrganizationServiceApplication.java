package com.daadestroyer.organizationservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "ORGANIZATION-SERVICE",
                description = "Spring Cloud Microservice : 8083",
                contact = @Contact(
                        name="Shubham",
                        email="nigamshubham2000@gmail.com",
                        url="https://shubhamnigam.netlify.app/"
                )

        )
)
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
        System.out.println("---------------------------");
        System.out.println("ORGANIZATION SERVICE - 8083");
        System.out.println("---------------------------");

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }

}
