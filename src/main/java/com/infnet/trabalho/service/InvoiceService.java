package com.infnet.trabalho.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.trabalho.model.Invoice;
import com.infnet.trabalho.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	InvoiceRepository repository;
	
	public List<Invoice> listar(){
		return repository.findAll();
	}
	
	public Optional<Invoice> listarPorId(Long id){
		return repository.findById(id);
	}
	
	public BigDecimal somaTotalCusto() {
		return repository.somaTotalCusto();
	}
}
