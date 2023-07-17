package com.jobappmanager.service;

import com.jobappmanager.model.Department;

import java.util.List;

public interface IdepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department createDepartment(Department department);

    void deleteDepartment(Long id);
}
