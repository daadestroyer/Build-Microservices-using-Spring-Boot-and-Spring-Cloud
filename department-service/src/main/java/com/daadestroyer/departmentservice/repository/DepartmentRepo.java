package com.daadestroyer.departmentservice.repository;

import com.daadestroyer.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findByDeptCode(String deptCode);
}
