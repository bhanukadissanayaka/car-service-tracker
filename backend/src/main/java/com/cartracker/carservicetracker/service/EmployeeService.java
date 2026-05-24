package com.cartracker.carservicetracker.service;

import com.cartracker.carservicetracker.model.Employee;
import com.cartracker.carservicetracker.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee registerEmployee(Employee employee) {

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        if (employee.getRole() == null || employee.getRole().isEmpty()) {
            employee.setRole("Mechanic");
        }

        if (employee.getAvailability() == null || employee.getAvailability().isEmpty()) {
            employee.setAvailability("Available");
        }

        if (employee.getServiceType() == null || employee.getServiceType().isEmpty()) {
            employee.setServiceType("General Service");
        }

        if (employee.getShift() == null || employee.getShift().isEmpty()) {
            employee.setShift("Morning");
        }

        return employeeRepository.save(employee);
    }

    public Employee loginEmployee(String email, String password) {

        Employee employee = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!employee.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setFullName(updatedEmployee.getFullName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        existingEmployee.setPassword(updatedEmployee.getPassword());
        existingEmployee.setRole(updatedEmployee.getRole());
        existingEmployee.setAvailability(updatedEmployee.getAvailability());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setExperienceYears(updatedEmployee.getExperienceYears());
        existingEmployee.setServiceType(updatedEmployee.getServiceType());
        existingEmployee.setPayableAmount(updatedEmployee.getPayableAmount());
        existingEmployee.setCarBrandSpecialty(updatedEmployee.getCarBrandSpecialty());
        existingEmployee.setShift(updatedEmployee.getShift());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}