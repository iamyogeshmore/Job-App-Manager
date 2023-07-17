package com.jobappmanager.service;

import com.jobappmanager.exception.JobAppManagerException;
import com.jobappmanager.model.Application;
import com.jobappmanager.model.Department;
import com.jobappmanager.model.JobRole;
import com.jobappmanager.repository.ApplicationRepository;
import com.jobappmanager.repository.DepartmentRepository;
import com.jobappmanager.repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements IapplicationService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    JobRoleRepository jobRoleRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    //--------------------------------- Submit Application---------------------------------

    public Application submitApplication(Long jobRoleId, Application application) {
        JobRole jobRole = jobRoleRepository.findById(jobRoleId)
                .orElseThrow(() -> new JobAppManagerException("Job role not found with id: " + jobRoleId));
        long id = jobRole.getDepartment().getId();
        Department department = departmentRepository.findById(id);
        application.setJobRole(jobRole);
        application.setDepartment(department);
        return applicationRepository.save(application);
    }

    //--------------------------------- Get All Applications ---------------------------------

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    //--------------------------------- Get Application By Id ---------------------------------
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new JobAppManagerException("Application not found with id: " + id));
    }

    //--------------------------------- Delete Application ---------------------------------
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
