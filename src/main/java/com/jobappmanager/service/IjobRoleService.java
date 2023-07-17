package com.jobappmanager.service;

import com.jobappmanager.model.JobRole;

import java.util.List;

public interface IjobRoleService {
    JobRole createJobRole(Long departmentId, JobRole jobRole);

    List<JobRole> getAllJobRoles();

    JobRole getJobRoleById(Long id);

    void deleteJobRole(Long id);
}
