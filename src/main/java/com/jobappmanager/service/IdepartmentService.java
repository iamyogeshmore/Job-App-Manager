package com.jobappmanager.service;

import com.jobappmanager.model.Department;

import java.util.List;

public interface IdepartmentService {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);
}
