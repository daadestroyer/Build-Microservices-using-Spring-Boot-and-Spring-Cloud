package com.daadestroyer.organizationservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "organization_name")
    private String organizationName;
    @NotNull
    @Column(name = "organization_desc")
    private String organizationDesc;

    @NotNull
    @Column(name = "organization_code")
    private String organizationCode;

    @Column(name = "organization_created_date")
    @CreationTimestamp
    private LocalDateTime organizationCreatedDate;
}
