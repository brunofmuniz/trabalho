package com.infnet.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.model.Customer;
import com.infnet.trabalho.service.CustomerService;

@RequestMapping("/Customer")
@RestController
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping
	public List<Customer> listar(){
		return service.listaTodos();
	}
	
	@PostMapping
	public ResponseEntity<?> criar(@RequestBody Customer customer){
		return ResponseEntity.ok(service.criar(customer));
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable String id){
		service.deletar(Long.parseLong(id));
	}
	
	@PutMapping(value = "/{id}")
	public void atualiza(@PathVariable String id, @RequestBody Customer customer) {
		service.atualiza(Long.parseLong(id), customer);
	}
}
