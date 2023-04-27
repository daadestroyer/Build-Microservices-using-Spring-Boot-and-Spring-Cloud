package com.daadestroyer.employeeservice.util;

import com.daadestroyer.employeeservice.dto.DepartmentDto;
import com.daadestroyer.employeeservice.dto.EmployeeDto;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class ApiClubResponse {

     public Object employeeData;
     public Object departmentData;
}
