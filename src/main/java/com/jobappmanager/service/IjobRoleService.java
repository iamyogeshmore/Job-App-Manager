package com.jobappmanager.service;

import com.jobappmanager.model.JobRole;

import java.util.List;

public interface IjobRoleService {
    List<JobRole> getAllJobRoles();

    JobRole getJobRoleById(Long id);

    JobRole createJobRole(Long departmentId, JobRole jobRole);

    void deleteJobRole(Long id);
}
