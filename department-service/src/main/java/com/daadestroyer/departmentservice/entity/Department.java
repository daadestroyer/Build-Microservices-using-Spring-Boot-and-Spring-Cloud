package com.daadestroyer.departmentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "deptName")
    private String deptName;
    @NotNull
    @Column(name = "deptDesc")
    private String deptDesc;
    @NotNull
    @Column(name = "deptCode")
    private String deptCode;
}
