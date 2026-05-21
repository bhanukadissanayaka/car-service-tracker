package com.cartracker.carservicetracker.service;

import com.cartracker.carservicetracker.model.Invoice;
import com.cartracker.carservicetracker.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice saveInvoice(Invoice invoice) {
        invoice.calculateTotalAmount();
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElse(null);

        if (existingInvoice == null) {
            return null;
        }

        existingInvoice.setCustomerName(updatedInvoice.getCustomerName());
        existingInvoice.setVehicleNumber(updatedInvoice.getVehicleNumber());
        existingInvoice.setServiceType(updatedInvoice.getServiceType());
        existingInvoice.setInvoiceDate(updatedInvoice.getInvoiceDate());
        existingInvoice.setLaborCost(updatedInvoice.getLaborCost());
        existingInvoice.setPartsCost(updatedInvoice.getPartsCost());
        existingInvoice.setDiscount(updatedInvoice.getDiscount());
        existingInvoice.setPaymentStatus(updatedInvoice.getPaymentStatus());

        existingInvoice.calculateTotalAmount();

        return invoiceRepository.save(existingInvoice);
    }

    public boolean deleteInvoice(Long id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}