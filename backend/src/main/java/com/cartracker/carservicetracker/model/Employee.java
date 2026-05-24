package com.cartracker.carservicetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;
    private String password;
    private String role;
    private String availability;
    private Double salary;
    private Integer experienceYears;
    private String serviceType;
    private Double payableAmount;
    private String carBrandSpecialty;
    private String shift;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getAvailability() {
        return availability;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public String getServiceType() {
        return serviceType;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public String getCarBrandSpecialty() {
        return carBrandSpecialty;
    }

    public String getShift() {
        return shift;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public void setCarBrandSpecialty(String carBrandSpecialty) {
        this.carBrandSpecialty = carBrandSpecialty;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}