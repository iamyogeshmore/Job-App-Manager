package com.jobappmanager.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Application {
    @Column(name = "Application")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String contactNumber;
    private int totalExperience;
    private double currentCTC;
    private double expectedCTC;
    private String skills;
    private String resume;
    private String coverLetter;
    @ManyToOne(fetch = FetchType.LAZY)
    private JobRole jobRole;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


}
