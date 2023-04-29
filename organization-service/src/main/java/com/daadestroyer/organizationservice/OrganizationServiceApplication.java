package com.daadestroyer.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
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
