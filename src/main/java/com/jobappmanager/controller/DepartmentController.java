package com.jobappmanager.controller;

import com.jobappmanager.dto.ResponseDTO;
import com.jobappmanager.model.Department;
import com.jobappmanager.service.DepartmentService;
import com.jobappmanager.service.IdepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
@Autowired
    IdepartmentService departmentService;
    List<Department> departmentList = new ArrayList<>();

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    //--------------------------------- Get all employee ---------------------------------
    @GetMapping("/getAllDepartments")
    public ResponseEntity<ResponseDTO> getAllDepartments() {
        departmentList = departmentService.getAllDepartments();
        ResponseDTO respOTO = new ResponseDTO(departmentList,"All department data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
    //--------------------------------- Get all employee ---------------------------------


    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}