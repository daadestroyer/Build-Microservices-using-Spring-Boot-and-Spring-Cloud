package com.daadestroyer.employeeservice.service;

import com.daadestroyer.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto saveEmployee(EmployeeDto employeeDto);

    public EmployeeDto getEmployee(Long id);

    public List<EmployeeDto> getListOfEmployee();

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);

    public String deleteEmployee(Long id);
}
