package com.infnet.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.trabalho.dto.OrderItemDTO;
import com.infnet.trabalho.model.OrderItem;
import com.infnet.trabalho.service.OrderItemService;

@RestController
@RequestMapping("/order-item")
public class OrderItemController {

	@Autowired
	OrderItemService service;
	
	@GetMapping
	public List<OrderItem> listar(){
		return service.listar();
	}
	
	@PostMapping
	public void create(@RequestBody OrderItemDTO dto) {
		service.create(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
