package com.cartracker.carservicetracker.controller;

import com.cartracker.carservicetracker.model.Invoice;
import com.cartracker.carservicetracker.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        boolean deleted = invoiceService.deleteInvoice(id);

        if (deleted) {
            return "Invoice deleted successfully";
        } else {
            return "Invoice not found";
        }
    }
}