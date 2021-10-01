package com.infnet.trabalho.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Invoice implements Serializable{

	private static final long serialVersionUID = -1626061574231258365L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoiceNumber;

	private LocalDateTime invoiceDate;
	private BigDecimal totalCost;
	private String otherDetails;

	@ManyToOne
	private Job job;

	@OneToMany
	private List<InvoiceLineItem> invoiceLineItens;

	public Long getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<InvoiceLineItem> getInvoiceLineItens() {
		return invoiceLineItens;
	}

	public void setInvoiceLineItens(List<InvoiceLineItem> invoiceLineItens) {
		this.invoiceLineItens = invoiceLineItens;
	}

}
