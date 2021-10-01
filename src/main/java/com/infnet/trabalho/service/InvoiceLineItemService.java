package com.infnet.trabalho.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infnet.trabalho.dto.InvoiceLineItemDTO;
import com.infnet.trabalho.model.Invoice;
import com.infnet.trabalho.model.InvoiceLineItem;
import com.infnet.trabalho.repository.InvoiceLineItemRepository;
import com.infnet.trabalho.repository.InvoiceRepository;

@Service
public class InvoiceLineItemService {

	@Autowired
	InvoiceLineItemRepository repository;
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public List<InvoiceLineItem> listar(){
		return repository.findAll();
	}
	
	public List<InvoiceLineItem> listarPorInvoice(Long id){
		return repository.findAllByInvoiceNumber(id);
	}
	
	@Transactional
	public void criar(InvoiceLineItemDTO dto) {
		
		InvoiceLineItem invoiceLineItem = new InvoiceLineItem();
		
		invoiceLineItem.setTaskName(dto.getTaskName());
		invoiceLineItem.setQuantity(dto.getQuantity());
		invoiceLineItem.setCost(dto.getCost());
		invoiceLineItem.setOtherDetails(dto.getOtherDetails());
		Invoice invoice = invoiceRepository.getOne(dto.getInvoiceId());
		invoiceLineItem.setInvoice(invoice);
		
		repository.save(invoiceLineItem);
	}
}
