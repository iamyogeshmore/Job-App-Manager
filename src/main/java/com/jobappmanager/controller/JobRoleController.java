package com.jobappmanager.controller;

import com.jobappmanager.dto.ResponseDTO;
import com.jobappmanager.model.Application;
import com.jobappmanager.model.JobRole;
import com.jobappmanager.service.ApplicationService;
import com.jobappmanager.service.IapplicationService;
import com.jobappmanager.service.IjobRoleService;
import com.jobappmanager.service.JobRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobroles")
public class JobRoleController {
    @Autowired
    IjobRoleService jobRoleService;
    @Autowired
    IapplicationService applicationService;
    List<JobRole> jobRoleList = new ArrayList<>();

    public JobRoleController(JobRoleService jobRoleService, ApplicationService applicationService) {
        this.jobRoleService = jobRoleService;
        this.applicationService = applicationService;
    }

    //--------------------------------- create Job Role ---------------------------------
    @PostMapping("/{departmentId}")
    public ResponseEntity<ResponseDTO> createJobRole(@PathVariable Long departmentId, @RequestBody JobRole jobRole) {
        JobRole jobRoles = jobRoleService.createJobRole(departmentId, jobRole);
        ResponseDTO respDTO = new ResponseDTO(jobRoles, " created Job Role.");
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- get All Job Roles ---------------------------------
    @GetMapping("/getAllJobRoles")
    public ResponseEntity<ResponseDTO> getAllJobRoles() {
        jobRoleList = jobRoleService.getAllJobRoles();
        ResponseDTO respOTO = new ResponseDTO(jobRoleList, "All Job roll data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get Job Role by id ---------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getJobRoleById(@PathVariable("id") Long id) {
        JobRole jobRoleData = jobRoleService.getJobRoleById(id);
        ResponseDTO respDTO = new ResponseDTO(jobRoleData, "Job roll data found successfully.");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


    //--------------------------------- Delete Job Role ---------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteJobRole(@PathVariable Long id) {
        jobRoleService.deleteJobRole(id);
        ResponseDTO respDTO = new ResponseDTO(id, "Deleted Successfully");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }


}