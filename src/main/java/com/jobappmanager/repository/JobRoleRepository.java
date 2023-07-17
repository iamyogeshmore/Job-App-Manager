    package com.jobappmanager.repository;

    import com.jobappmanager.model.JobRole;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
    }
