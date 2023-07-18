package com.jobappmanager.controller;

import com.jobappmanager.dto.ResponseDTO;
import com.jobappmanager.model.Department;
import com.jobappmanager.service.IdepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin("*")
public class DepartmentController {
    @Autowired
    IdepartmentService departmentService;
    List<Department> departmentList = new ArrayList<>();

    //--------------------------------- Create Department ---------------------------------
    @PostMapping("/createDepartment")
    public ResponseEntity<ResponseDTO> createDepartment(@RequestBody Department department) {
        Department department1 = departmentService.createDepartment(department);
        ResponseDTO respOTO = new ResponseDTO(department1, "Register new department successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get All Departments ---------------------------------
    @GetMapping("/getAllDepartments")
    public ResponseEntity<ResponseDTO> getAllDepartments() {
        departmentList = departmentService.getAllDepartments();
        ResponseDTO respOTO = new ResponseDTO(departmentList, "All department data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get Department By Id ---------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getDepartmentById(@PathVariable Long id) {
        Department department = departmentService.getDepartmentById(id);
        ResponseDTO respDTO = new ResponseDTO(department, "department data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Department ---------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        ResponseDTO respDTO = new ResponseDTO(id, "Department deleted successfully");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}