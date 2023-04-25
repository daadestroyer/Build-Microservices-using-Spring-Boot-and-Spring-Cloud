package com.daadestroyer.departmentservice.service.Impl;

import com.daadestroyer.departmentservice.dto.DepartmentDto;
import com.daadestroyer.departmentservice.entity.Department;
import com.daadestroyer.departmentservice.exceptionhandling.ResourceAlreadyExistedException;
import com.daadestroyer.departmentservice.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.departmentservice.repository.DepartmentRepo;
import com.daadestroyer.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = this.modelMapper.map(departmentDto, Department.class);
        Department departmentSaved = this.departmentRepo.save(department);
        return this.modelMapper.map(departmentSaved, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartment(Long id) {
        Department department = this.departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", id));
        return this.modelMapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<DepartmentDto> departmentDtoList = this.departmentRepo.findAll().stream().map((dept) -> this.modelMapper.map(dept, DepartmentDto.class)).collect(Collectors.toList());
        if (departmentDtoList.size() == 0) {
            throw new ResourceNotFoundException("Department List");
        }
        return departmentDtoList;
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id) {

        Department savedDepartment = this.departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", id));

        savedDepartment.setDeptName(departmentDto.getDeptName());
        savedDepartment.setDeptCode(departmentDto.getDeptCode());
        savedDepartment.setDeptDesc(departmentDto.getDeptDesc());

        Department departmentUpdated = this.departmentRepo.save(savedDepartment);
        return this.modelMapper.map(departmentUpdated, DepartmentDto.class);
    }

    @Override
    public String deleteDepartment(Long id) {
        Department department = this.departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", id));
        this.departmentRepo.delete(department);

        return department.getDeptName() + " Department Deleted...";
    }

    @Override
    public DepartmentDto getDeptByCode(String deptCode) {
        Department department = this.departmentRepo.findByDeptCode(deptCode);
        return this.modelMapper.map(department, DepartmentDto.class);
    }
}
