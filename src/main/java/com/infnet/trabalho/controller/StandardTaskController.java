package com.infnet.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.model.StandardTask;
import com.infnet.trabalho.service.StandardTaskService;

@RestController
@RequestMapping("/task")
public class StandardTaskController {

	@Autowired
	StandardTaskService service;
	
	@GetMapping
	public List<StandardTask> listar(){
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody StandardTask task) {
		return ResponseEntity.ok(service.criar(task));
	}
	
	@PutMapping(value = "/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody StandardTask task) {
		service.update(id, task);
	}
	
	@GetMapping(value = "/preco-crescente")
	public List<StandardTask> precoCrescente(){
		return service.precoCrescente();
	}
	
	@GetMapping(value = "/preco-decrescente")
	public List<StandardTask> precoDecrescente(){
		return service.precoDecrescente();
	}
}
