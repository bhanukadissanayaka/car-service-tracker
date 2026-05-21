package com.cartracker.carservicetracker.repository;

import com.cartracker.carservicetracker.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}