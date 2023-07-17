package com.jobappmanager.service;

import com.jobappmanager.exception.JobAppManagerException;
import com.jobappmanager.model.Department;
import com.jobappmanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IdepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    //--------------------------------- Create Department ---------------------------------
    public Department createDepartment(Department department) {
        String departmentName = department.getDepartmentName();
        Department existingDepartment = departmentRepository.findByDepartmentName(departmentName);
        if (existingDepartment != null) {
            throw new JobAppManagerException("Department already exists with the same name.");
        }
        return departmentRepository.save(department);
    }

    //--------------------------------- Get All Departments ---------------------------------
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    //--------------------------------- Get Department By Id ---------------------------------
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new JobAppManagerException("Department not found with id: " + id));
    }

    //--------------------------------- Delete Department ---------------------------------
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}