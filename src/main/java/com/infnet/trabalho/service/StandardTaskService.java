package com.infnet.trabalho.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infnet.trabalho.model.StandardTask;
import com.infnet.trabalho.repository.StandardTaskRepository;

@Service
public class StandardTaskService {

	@Autowired
	StandardTaskRepository repository;
	
	public List<StandardTask> listar(){
		return repository.findAll();
	}
	
	@Transactional
	public StandardTask criar(StandardTask task) {
			return repository.save(task);
	}
	
	@Transactional
	public void update(Long id, StandardTask task) {
		StandardTask entity = repository.getById(task.getId());
		
		entity.setOtherDetails(task.getOtherDetails());
		entity.setTaskDescription(task.getTaskDescription());
		entity.setTaskName(task.getTaskName());
		entity.setTaskPrice(task.getTaskPrice());
		
		repository.save(entity);
	}
	
	public List<StandardTask> precoCrescente(){
		return repository.findByOrderByTaskPriceAsc();
	}
	
	
	
	public List<StandardTask> precoDecrescente(){
		return repository.findByOrderByTaskPriceDesc();
	}
}
