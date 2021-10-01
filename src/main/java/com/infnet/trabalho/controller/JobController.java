package com.infnet.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.model.Job;
import com.infnet.trabalho.service.JobService;

@RequestMapping("/job")
@RestController
public class JobController {

	@Autowired
	JobService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable("id") Long id){
		try {
			return ResponseEntity.ok(service.listarPorId(id));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new IllegalArgumentException());
		}
	}
	
	@GetMapping
	public List<Job> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/data-inicio-asc")
	public List<Job> listarPorDataInicio(){
		return service.filtroDataInicioAsc();
	}
	
	@GetMapping(value = "/data-fim-asc")
	public List<Job> listarPorDataFim(){
		return service.filtrarPorDataFim();
	}
	
}
