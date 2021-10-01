package com.infnet.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infnet.trabalho.model.StandardTask;

@Repository
public interface StandardTaskRepository extends JpaRepository<StandardTask, Long>{

	List<StandardTask> findByOrderByTaskPriceAsc();
	List<StandardTask> findByOrderByTaskPriceDesc();

}
