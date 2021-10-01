package com.infnet.trabalho.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infnet.trabalho.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

	@Query(value = "select sum(total_cost) from invoice", nativeQuery = true)
	BigDecimal somaTotalCusto();

}
