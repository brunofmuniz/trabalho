package com.infnet.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infnet.trabalho.model.InvoiceLineItem;

@Repository
public interface InvoiceLineItemRepository extends JpaRepository<InvoiceLineItem, Long>{

	@Query(value = "select * from invoice_line_item where invoice_invoice_number = ?", nativeQuery = true)
	List<InvoiceLineItem> findAllByInvoiceNumber(Long id);

}
