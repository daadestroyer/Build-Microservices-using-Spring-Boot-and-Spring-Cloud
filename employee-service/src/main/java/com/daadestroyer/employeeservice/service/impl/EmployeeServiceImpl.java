package com.daadestroyer.employeeservice.service.impl;

import com.daadestroyer.employeeservice.dto.DepartmentDto;
import com.daadestroyer.employeeservice.dto.EmployeeDto;
import com.daadestroyer.employeeservice.dto.OrganizationDto;
import com.daadestroyer.employeeservice.entity.Employee;
import com.daadestroyer.employeeservice.exceptionhandling.APIResponse;
import com.daadestroyer.employeeservice.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.employeeservice.repository.EmployeeRepository;
import com.daadestroyer.employeeservice.service.APIClient;
import com.daadestroyer.employeeservice.service.EmployeeService;
import com.daadestroyer.employeeservice.util.ApiClubResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    static int i =1;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

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


    @CircuitBreaker(name = "EMPLOYEE-SERVICE", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "EMPLOYEE-SERVICE",fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiClubResponse getEmployee(Long id) {
        System.out.println("retry :"+(i++));
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
//        ResponseEntity<DepartmentDto> responseEntity = this.restTemplate.getForEntity("http://localhost:8080/api/departments/get-dept-by-code/" + employee.getDeptCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/get-dept-by-code/" + employee.getDeptCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

//        DepartmentDto departmentDto = apiClient.getDeptByCode(employee.getDeptCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/get-org-by-code/" + employee.getOrgCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
        System.out.println("ORG DATA === "+organizationDto);
        ApiClubResponse apiClubResponse = ApiClubResponse.builder().employeeData(this.modelMapper.map(employee, EmployeeDto.class)).departmentData(departmentDto).organizationData(organizationDto).build();

        return apiClubResponse;
    }

    public ApiClubResponse getDefaultDepartment(Long id,Exception exception) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", id));
        DepartmentDto departmentDto = DepartmentDto.builder().deptCode("default dept").deptDesc("default dept desc").deptName("default dept name").id(1001L).build();
        ApiClubResponse apiClubResponse = ApiClubResponse.builder().employeeData(this.modelMapper.map(employee, EmployeeDto.class)).departmentData(departmentDto).build();

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
