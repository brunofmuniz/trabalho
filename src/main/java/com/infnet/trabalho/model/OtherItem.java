package com.infnet.trabalho.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OtherItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long quantity;
	private BigDecimal cost;
	private String otherDetails;

	@ManyToOne
	private Job job;

	@ManyToOne
	private StandardTask task;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
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

	public StandardTask getTask() {
		return task;
	}

	public void setTask(StandardTask task) {
		this.task = task;
	}

}
