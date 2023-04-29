package com.daadestroyer.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationDto {
    private Long id;

    @NotEmpty(message = "please enter your organization name")
    private String organizationName;

    @NotEmpty(message = "please enter your organization description")
    private String organizationDesc;

    @NotEmpty(message = "please enter your organization code")
    private String organizationCode;

//    @NotNull
//    @Column(name = "organization_created_date")
//    @CreationTimestamp
//    private LocalDateTime organizationCreatedDate;
}
