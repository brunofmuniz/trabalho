package com.infnet.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infnet.trabalho.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

	List<Job> findByOrderByDataJobStartedAsc();
	List<Job> findByOrderByDataJobCompletedAsc();

}
