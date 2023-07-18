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
        String newEmail = application.getEmail();
        String newContactNumber = application.getContactNumber();

        Application existingEmail = applicationRepository.findByEmail(newEmail);
        if (existingEmail != null) {
            throw new JobAppManagerException("Application already exists with the same email.");
        }

        Application existingContactNumber = applicationRepository.findByContactNumber(newContactNumber);
        if (existingContactNumber != null) {
            throw new JobAppManagerException("Application already exists with the same contact number.");
        }

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
    public String deleteApplication(Long id) {
        if (applicationRepository.findById(id).isPresent()) {
            applicationRepository.deleteById(id);
            return "Data Deleted successfully.";
        }
        throw new JobAppManagerException("Application not found from Id " + id + " Invalid Id ");
    }
}