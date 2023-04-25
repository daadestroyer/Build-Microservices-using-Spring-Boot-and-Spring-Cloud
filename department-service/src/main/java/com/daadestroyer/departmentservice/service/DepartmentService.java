package com.daadestroyer.departmentservice.service;

import com.daadestroyer.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartment(Long id);

    public List<DepartmentDto> getAllDepartment();

    public DepartmentDto updateDepartment(DepartmentDto departmentDto,Long id);

    public String deleteDepartment(Long id);

    public DepartmentDto getDeptByCode(String deptCode);
}
