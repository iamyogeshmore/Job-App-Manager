package com.jobappmanager.dto;

import lombok.Data;

@Data
public class ApplicationDTO {
    private String email;
    private Long id;
    private String fullName;
    private String contactNumber;
    private int totalExperience;
    private double currentCTC;
    private double expectedCTC;
    private String skills;
    private String resume;
    private String coverLetter;
    private Long jobRoleId;

}
