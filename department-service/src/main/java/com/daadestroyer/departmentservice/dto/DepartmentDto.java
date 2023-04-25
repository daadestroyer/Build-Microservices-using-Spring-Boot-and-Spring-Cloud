package com.daadestroyer.departmentservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DepartmentDto {

    private Long id;
    @NotEmpty
    @Size(min = 5, max = 20)
    private String deptName;
    @NotEmpty
    @Size(min = 10, max = 1000)
    private String deptDesc;
    @NotEmpty
    @Size(min = 6, max = 20)
    private String deptCode;
}
