package com.daadestroyer.employeeservice.controller;


import com.daadestroyer.employeeservice.dto.EmployeeDto;
import com.daadestroyer.employeeservice.service.impl.EmployeeServiceImpl;
import com.daadestroyer.employeeservice.util.ApiClubResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    // http://localhost:8081/save-emp
    @PostMapping("/save-emp")
    public ResponseEntity<?> saveEmp(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = this.employeeServiceImpl.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.OK);
    }

    // http://localhost:8081/get-all-emp
    @GetMapping("/get-all-emp")
    public ResponseEntity<?> getAllEmp() {
        List<EmployeeDto> listOfEmployee = this.employeeServiceImpl.getListOfEmployee();

        return new ResponseEntity<>(listOfEmployee, HttpStatus.OK);
    }

    // http://localhost:8081/get-emp/1
    @GetMapping("/get-emp/{id}")
    public ResponseEntity<?> getEmp(@PathVariable Long id) {
        ApiClubResponse apiClubResponse = this.employeeServiceImpl.getEmployee(id);
        return new ResponseEntity<>(apiClubResponse, HttpStatus.OK);
    }
}
