package com.jobappmanager.service;

import com.jobappmanager.exception.JobAppManagerException;
import com.jobappmanager.model.Department;
import com.jobappmanager.model.JobRole;
import com.jobappmanager.repository.DepartmentRepository;
import com.jobappmanager.repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobRoleService implements IjobRoleService {

    @Autowired
    JobRoleRepository jobRoleRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    //--------------------------------- Create Job Role ---------------------------------
    public JobRole createJobRole(Long departmentId, JobRole jobRole) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new JobAppManagerException("Department not found with id: " + departmentId));
        jobRole.setDepartment(department);
        return jobRoleRepository.save(jobRole);
    }

    //--------------------------------- Get All Job Roles ---------------------------------
    public List<JobRole> getAllJobRoles() {
        return jobRoleRepository.findAll();
    }

    //--------------------------------- Get Job Role By Id ---------------------------------
    public JobRole getJobRoleById(Long id) {
        return jobRoleRepository.findById(id)
                .orElseThrow(() -> new JobAppManagerException("Job role not found with id: " + id));
    }

    //--------------------------------- Delete Job Role ---------------------------------
    public void deleteJobRole(Long id) {
        jobRoleRepository.deleteById(id);
    }
}