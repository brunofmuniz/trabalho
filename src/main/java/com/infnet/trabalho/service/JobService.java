package com.infnet.trabalho.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.trabalho.model.Job;
import com.infnet.trabalho.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository repository;
	
	public Optional<Job> listarPorId(Long id){
		return repository.findById(id);
	}
	
	public List<Job> listar(){
		return repository.findAll();
	}
	
	public List<Job> filtroDataInicioAsc(){
		return repository.findByOrderByDataJobStartedAsc();
	}
	
	public List<Job> filtrarPorDataFim(){
		return repository.findByOrderByDataJobCompletedAsc();
	}

}
