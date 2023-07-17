package com.jobappmanager.controller;

import com.jobappmanager.dto.ResponseDTO;
import com.jobappmanager.model.Application;
import com.jobappmanager.service.IapplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    IapplicationService iapplicationService;
    List<Application> applicationList = new ArrayList<>();

    //--------------------------------- Submit Application ---------------------------------

    @PostMapping("/{jobRoleId}/applications")

    public ResponseEntity<ResponseDTO> submitApplication(@PathVariable Long jobRoleId, @RequestBody Application application) {
        iapplicationService.submitApplication(jobRoleId, application);
        ResponseDTO respDTO = new ResponseDTO(application, "Submit Application Successfully.");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
    //--------------------------------- Get All Applications ---------------------------------

    @GetMapping("/getAllApplications")
    public ResponseEntity<ResponseDTO> showAllApplications() {
        applicationList = iapplicationService.getAllApplications();
        ResponseDTO respOTO = new ResponseDTO(applicationList, "All application data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Get Department By Id ---------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getApplicationById(@PathVariable Long id) {
        Application application = iapplicationService.getApplicationById(id);
        ResponseDTO respDTO = new ResponseDTO(id, "Application data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Department ---------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteApplication(@PathVariable Long id) {
        iapplicationService.deleteApplication(id);
        ResponseDTO respDTO = new ResponseDTO(id, "Application deleted successfully");
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
