package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
