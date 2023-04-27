package com.daadestroyer.departmentservice.controller;

import com.daadestroyer.departmentservice.dto.DepartmentDto;
import com.daadestroyer.departmentservice.service.Impl.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    // http://localhost:8080/save-dept
    @PostMapping("/save-dept")
    public ResponseEntity<?> saveDept(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = this.departmentServiceImpl.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.OK);
    }

    // http://localhost:8080/get-dept/1
    @GetMapping("/get-dept/{id}")
    public ResponseEntity<?> getDept(@PathVariable Long id) {
        DepartmentDto department = this.departmentServiceImpl.getDepartment(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // http://localhost:8080/get-all-dept
    @GetMapping("/get-all-dept")
    public ResponseEntity<?> getAllDept() {
        List<DepartmentDto> allDepartment = this.departmentServiceImpl.getAllDepartment();
        return new ResponseEntity<>(allDepartment, HttpStatus.OK);
    }

    // http://localhost:8080/update-dept
    @PutMapping("/update-dept/{id}")
    public ResponseEntity<?> updateDept(@RequestBody DepartmentDto departmentDto, @PathVariable Long id) {
        DepartmentDto updatedDepartment = this.departmentServiceImpl.updateDepartment(departmentDto, id);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    // http://localhost:8080/get-dept-by-code/HR_1001_GEN
    @GetMapping("/get-dept-by-code/{deptCode}")
    public ResponseEntity<?> getDeptByCode(@PathVariable String deptCode) {
        DepartmentDto deptByCode = this.departmentServiceImpl.getDeptByCode(deptCode);
        return new ResponseEntity<>(deptByCode, HttpStatus.OK);
    }

}
