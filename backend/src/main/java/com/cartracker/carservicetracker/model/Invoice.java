package com.cartracker.carservicetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    private String customerName;
    private String vehicleNumber;
    private String serviceType;
    private String invoiceDate;

    private double laborCost;
    private double partsCost;
    private double discount;
    private double totalAmount;

    private String paymentStatus;

    public Invoice() {
    }

    public Invoice(String customerName, String vehicleNumber, String serviceType,
                   String invoiceDate, double laborCost, double partsCost,
                   double discount, String paymentStatus) {
        this.customerName = customerName;
        this.vehicleNumber = vehicleNumber;
        this.serviceType = serviceType;
        this.invoiceDate = invoiceDate;
        this.laborCost = laborCost;
        this.partsCost = partsCost;
        this.discount = discount;
        this.paymentStatus = paymentStatus;
        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        this.totalAmount = (this.laborCost + this.partsCost) - this.discount;
    }

    @PrePersist
    @PreUpdate
    public void beforeSave() {
        calculateTotalAmount();
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
        calculateTotalAmount();
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
        calculateTotalAmount();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        calculateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}