package com.daadestroyer.employeeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "EMPLOYEE-SERVICE",
                description = "Spring Cloud Microservice : 8081",
                contact = @Contact(
                        name="Shubham",
                        email="nigamshubham2000@gmail.com",
                        url="https://shubhamnigam.netlify.app/"
                )

        )
)
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
        System.out.println("-----------------------");
        System.out.println("EMPLOYEE SERVICE - 8081");
        System.out.println("-----------------------");
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
