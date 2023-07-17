package com.jobappmanager.service;

import com.jobappmanager.exception.JobAppManagerException;
import com.jobappmanager.model.Application;
import com.jobappmanager.model.JobRole;
import com.jobappmanager.repository.ApplicationRepository;
import com.jobappmanager.repository.JobRoleRepository;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;

    //--------------------------------- Register New Application---------------------------------
//    @Override
//    public Application RegisterNewApplication(ApplicationDTO applicationDTO) {
//        if (applicationRepository.findByEmail(applicationDTO.getEmail()) == null) {
//            Application registerNewUser = modelMapper.map(applicationDTO, Application.class);
//            applicationRepository.save(registerNewUser);
//            return registerNewUser;
//        }
//        throw new JobAppManagerException("Application Already Exist with this Email id ." + "\n Please Try with Another Email id");
//    }
    //--------------------------------- Submit Application---------------------------------

    public Application submitApplication(Long jobRoleId, Application application) {
        JobRole jobRole = jobRoleRepository.findById(jobRoleId)
                .orElseThrow(() -> new JobAppManagerException("Job role not found with id: " + jobRoleId));
        application.setJobRole(jobRole);
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
