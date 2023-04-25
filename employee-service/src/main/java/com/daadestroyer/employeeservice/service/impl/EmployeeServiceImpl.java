package com.daadestroyer.employeeservice.service.impl;

import com.daadestroyer.employeeservice.dto.EmployeeDto;
import com.daadestroyer.employeeservice.entity.Employee;
import com.daadestroyer.employeeservice.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.employeeservice.repository.EmployeeRepository;
import com.daadestroyer.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = this.modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return this.modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        return this.modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getListOfEmployee() {

        List<EmployeeDto> employeeDtoList = this.employeeRepository.findAll().stream().map((emp) -> this.modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
        if (employeeDtoList.size() == 0) {
            throw new ResourceNotFoundException("Employee");
        }
        return employeeDtoList;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
        return null;
    }

    @Override
    public String deleteEmployee(Long id) {
        return null;
    }
}
