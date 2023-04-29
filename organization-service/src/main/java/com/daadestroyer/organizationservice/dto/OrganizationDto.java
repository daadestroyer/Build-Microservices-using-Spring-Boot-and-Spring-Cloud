package com.daadestroyer.organizationservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
