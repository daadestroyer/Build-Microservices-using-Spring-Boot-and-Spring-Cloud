package com.daadestroyer.employeeservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmployeeDto {
    private Long id;

    @NotEmpty(message = "please enter your firstname")
    @Size(min = 5, max = 10)
    private String firstName;

    @NotEmpty(message = "please enter your lastname")
    @Size(min = 5, max = 10)
    private String lastName;

    @Email
    @NotEmpty(message = "please enter your email")
    private String email;

    private String deptCode;
}
