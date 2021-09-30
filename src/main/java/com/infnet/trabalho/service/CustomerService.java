package com.infnet.trabalho.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.trabalho.model.Customer;
import com.infnet.trabalho.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public List<Customer> listaTodos(){
		return repository.findAll();
	}
	
	@Transactional
	public Customer criar(Customer customer) {
		return repository.save(customer);
	}
	
	@Transactional
	public void atualiza(Long id, Customer customer) {
		Customer entity = repository.getOne(id);
		
		entity.setFirstName(customer.getFirstName());
		entity.setLastName(customer.getLastName());
		entity.setEmail(customer.getEmail());
		entity.setGender(customer.getGender());
		entity.setMiddleInitial(customer.getMiddleInitial());
		
		repository.save(entity);
	}
	
	@Transactional
	public void deletar(Long id) {
		repository.deleteById(id);
	}
	
}
