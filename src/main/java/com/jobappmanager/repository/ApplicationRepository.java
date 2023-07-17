package com.jobappmanager.repository;

import com.jobappmanager.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Application findByEmail(String newName);

    Application findByContactNumber(String contactNumber);
}
