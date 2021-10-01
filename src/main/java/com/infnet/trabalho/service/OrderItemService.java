package com.infnet.trabalho.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.trabalho.dto.OrderItemDTO;
import com.infnet.trabalho.model.Job;
import com.infnet.trabalho.model.OrderItem;
import com.infnet.trabalho.model.StandardTask;
import com.infnet.trabalho.repository.JobRepository;
import com.infnet.trabalho.repository.OrderItemRepository;
import com.infnet.trabalho.repository.StandardTaskRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository repository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	StandardTaskRepository taskRepository;
	
	@Transactional
	public void create(OrderItemDTO dto) {	
		
		if(dto.getId() == null) {
			
			OrderItem orderItem = new OrderItem();
			
			orderItem.setCost(dto.getCost());
			orderItem.setOtherDetails(dto.getOtherDetails());
			orderItem.setQuantity(dto.getQuantity());
			
			Job job = jobRepository.getOne(dto.getJobId());
			StandardTask task = taskRepository.getOne(dto.getTaskId());
			
			orderItem.setJob(job);
			orderItem.setTask(task);
			
			repository.save(orderItem);
		}else {
			
			OrderItem entity = repository.getOne(dto.getId());
			
			entity.setCost(dto.getCost());
			entity.setOtherDetails(dto.getOtherDetails());
			entity.setQuantity(dto.getQuantity());
			
			repository.save(entity);
		}
	}
	
	@Transactional
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
	public List<OrderItem> listar(){
		return repository.findAll();
	}
	
}
