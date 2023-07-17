package com.jobappmanager.dto;

import lombok.Data;

@Data
public class JobRoleDTO {
    public Long id;
    public String roleName;
    public String experience;
    public String location;
    public Long departmentId;
}
