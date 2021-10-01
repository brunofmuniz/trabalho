package com.infnet.trabalho.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Job implements Serializable{

	private static final long serialVersionUID = -8037362810904827938L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDateTime dataJobStarted;
	private LocalDateTime dataJobCompleted;
	private String otherDetails;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany
	private List<Invoice> invoices;
	
	@OneToMany
	private List<OrderItem> otherItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataJobStarted() {
		return dataJobStarted;
	}

	public void setDataJobStarted(LocalDateTime dataJobStarted) {
		this.dataJobStarted = dataJobStarted;
	}

	public LocalDateTime getDataJobCompleted() {
		return dataJobCompleted;
	}

	public void setDataJobCompleted(LocalDateTime dataJobCompleted) {
		this.dataJobCompleted = dataJobCompleted;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
