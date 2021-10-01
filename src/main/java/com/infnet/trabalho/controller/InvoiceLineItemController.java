package com.infnet.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.dto.InvoiceLineItemDTO;
import com.infnet.trabalho.model.InvoiceLineItem;
import com.infnet.trabalho.service.InvoiceLineItemService;

@RestController
@RequestMapping("/invoice-line-item")
public class InvoiceLineItemController {

	@Autowired
	InvoiceLineItemService service;
	
	@GetMapping
	public List<InvoiceLineItem> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/listar-por-invoice/{id}")
	public List<InvoiceLineItem> listarporInvoice(@PathVariable Long id){
		return service.listarPorInvoice(id);
	}
	
	@PostMapping
	public void criar(@RequestBody InvoiceLineItemDTO dto) {
		service.criar(dto);
	}
}
