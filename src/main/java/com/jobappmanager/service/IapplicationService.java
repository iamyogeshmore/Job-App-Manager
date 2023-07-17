package com.jobappmanager.service;

import com.jobappmanager.model.Application;

import java.util.List;

public interface IapplicationService {
    List<Application> getAllApplications();

    Application submitApplication(Long jobRoleId, Application application);

    Application getApplicationById(Long id);

    String deleteApplication(Long id);
}
