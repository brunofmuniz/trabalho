package com.infnet.trabalho.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.model.Invoice;
import com.infnet.trabalho.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService service;
	
	@GetMapping
	public List<Invoice> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Invoice> listarPorId(@PathVariable("id") Long id){
		return service.listarPorId(id);
	}
	
	@GetMapping(value = "/soma-total-custo")
	public BigDecimal somaTotalCusto() {
		return service.somaTotalCusto();
	}
}
