package com.jobappmanager.service;

import com.jobappmanager.dto.ApplicationDTO;
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

    @Override
    public Application RegisterNewApplication(ApplicationDTO applicationDTO) {
        if (applicationRepository.findByEmail(applicationDTO.getEmail()) == null) {
            Application registerNewUser = modelMapper.map(applicationDTO,Application.class);
            applicationRepository.save(registerNewUser);
            return registerNewUser;
        }
        throw  new JobAppManagerException("Application Already Exist with this Email id ."+"\n Please Try with Another Email id");
    }

        public ApplicationService(ApplicationRepository applicationRepository, JobRoleRepository jobRoleRepository) {
            this.applicationRepository = applicationRepository;
            this.jobRoleRepository = jobRoleRepository;
        }

        public Application submitApplication(Long jobRoleId, Application application) {
            JobRole jobRole = jobRoleRepository.findById(jobRoleId)
                    .orElseThrow(() -> new JobAppManagerException("Job role not found with id: " + jobRoleId));
            application.setJobRole(jobRole);
            return applicationRepository.save(application);
        }

        public List<Application> getAllApplications() {
            return applicationRepository.findAll();
        }

        public Application getApplicationById(Long id) {
            return applicationRepository.findById(id)
                    .orElseThrow(() -> new JobAppManagerException("Application not found with id: " + id));
        }

        public void deleteApplication(Long id) {
            applicationRepository.deleteById(id);

    }
}
