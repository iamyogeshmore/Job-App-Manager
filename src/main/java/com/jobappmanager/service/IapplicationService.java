package com.jobappmanager.service;

import com.jobappmanager.dto.ApplicationDTO;
import com.jobappmanager.model.Application;

import java.util.List;

public interface IapplicationService {
//    Application RegisterNewApplication(ApplicationDTO applicationDTO);

    List<Application> getAllApplications();

    Application submitApplication(Long jobRoleId, Application application);
}
