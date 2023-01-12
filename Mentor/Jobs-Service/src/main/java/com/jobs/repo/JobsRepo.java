package com.jobs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobs.entity.Jobs;

@Repository
public interface JobsRepo extends JpaRepository<Jobs,Long> {

}
