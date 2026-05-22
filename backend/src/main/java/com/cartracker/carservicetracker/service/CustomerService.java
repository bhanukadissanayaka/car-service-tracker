package com.cartracker.carservicetracker.service;

import com.cartracker.carservicetracker.model.Customer;
import com.cartracker.carservicetracker.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        return customerRepository.save(customer);
    }

    public Customer addCustomer(Customer customer) {
        return registerCustomer(customer);
    }

    public Customer loginCustomer(String email, String password) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (!customer.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);

        if (updatedCustomer.getEmail() != null
                && !updatedCustomer.getEmail().equalsIgnoreCase(existingCustomer.getEmail())
                && customerRepository.existsByEmailAndIdNot(updatedCustomer.getEmail(), id)) {
            throw new RuntimeException("Email already registered");
        }

        existingCustomer.setFullName(updatedCustomer.getFullName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            existingCustomer.setPassword(updatedCustomer.getPassword());
        }

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
