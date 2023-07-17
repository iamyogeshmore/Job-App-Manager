package com.jobappmanager.controller;

import com.jobappmanager.dto.ApplicationDTO;
import com.jobappmanager.dto.ResponseDTO;
import com.jobappmanager.model.Application;
import com.jobappmanager.service.IapplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    IapplicationService iapplicationService;
    List<Application> applicationList = new ArrayList<>();

    //--------------------------------- Add Application ---------------------------------
    @PostMapping("/Register_Application")
    public ResponseEntity<ResponseDTO> RegisterNewApplication(@RequestBody ApplicationDTO applicationDTO) {
        Application newApplicationData = iapplicationService.RegisterNewApplication(applicationDTO);
        ResponseDTO respOTO = new ResponseDTO(newApplicationData, "Register new application successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }

    //--------------------------------- Add Application ---------------------------------

    @GetMapping("/getAllApplications")
    public ResponseEntity<ResponseDTO> showAllApplications() {
        applicationList = iapplicationService.getAllApplications();
        ResponseDTO respOTO = new ResponseDTO(applicationList, "All application data retrieved successfully.");
        return new ResponseEntity<ResponseDTO>(respOTO, HttpStatus.OK);
    }
}
