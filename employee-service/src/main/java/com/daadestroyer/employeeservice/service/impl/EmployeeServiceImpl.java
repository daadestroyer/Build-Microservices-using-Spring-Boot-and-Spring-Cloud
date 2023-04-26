package com.daadestroyer.employeeservice.service.impl;

import com.daadestroyer.employeeservice.dto.DepartmentDto;
import com.daadestroyer.employeeservice.dto.EmployeeDto;
import com.daadestroyer.employeeservice.entity.Employee;
import com.daadestroyer.employeeservice.exceptionhandling.APIResponse;
import com.daadestroyer.employeeservice.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.employeeservice.repository.EmployeeRepository;
import com.daadestroyer.employeeservice.service.EmployeeService;
import com.daadestroyer.employeeservice.util.ApiClubResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private RestTemplate restTemplate;
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
    public ApiClubResponse getEmployee(Long id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        ResponseEntity<DepartmentDto> responseEntity = this.restTemplate.getForEntity("http://localhost:8080/get-dept-by-code/" + employee.getDeptCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        ApiClubResponse apiClubResponse = ApiClubResponse.builder().ob1(this.modelMapper.map(employee, EmployeeDto.class)).ob2(departmentDto).build();

        return apiClubResponse;
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
