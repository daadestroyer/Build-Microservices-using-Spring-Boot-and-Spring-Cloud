package com.daadestroyer.employeeservice.service;

import com.daadestroyer.employeeservice.dto.EmployeeDto;
import com.daadestroyer.employeeservice.util.ApiClubResponse;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public ApiClubResponse getEmployee(Long id);

    public List<EmployeeDto> getListOfEmployee();

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);

    public String deleteEmployee(Long id);
}
