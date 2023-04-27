package com.daadestroyer.employeeservice.service;

import com.daadestroyer.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/get-dept-by-code/{deptCode}")
    public DepartmentDto getDeptByCode(@PathVariable String deptCode);

}
