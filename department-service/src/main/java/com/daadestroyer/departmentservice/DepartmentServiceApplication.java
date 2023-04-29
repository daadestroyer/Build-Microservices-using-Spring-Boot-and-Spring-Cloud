package com.daadestroyer.departmentservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
        System.out.println("-------------------------");
        System.out.println("DEPARTMENT SERVICE - 8080");
        System.out.println("-------------------------");
    }


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
