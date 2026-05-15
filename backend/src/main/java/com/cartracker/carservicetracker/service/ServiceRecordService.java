package com.cartracker.carservicetracker.service;

import com.cartracker.carservicetracker.model.Car;
import com.cartracker.carservicetracker.model.ServiceRecord;
import com.cartracker.carservicetracker.repository.CarRepository;
import com.cartracker.carservicetracker.repository.ServiceRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRecordService {

    private final ServiceRecordRepository serviceRecordRepository;
    private final CarRepository carRepository;

    public ServiceRecordService(ServiceRecordRepository serviceRecordRepository,
                                CarRepository carRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
        this.carRepository = carRepository;
    }

    public ServiceRecord addServiceRecord(Long carId, ServiceRecord serviceRecord) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        serviceRecord.setCar(car);

        if (serviceRecord.getStatus() == null || serviceRecord.getStatus().isEmpty()) {
            serviceRecord.setStatus("Completed");
        }

        return serviceRecordRepository.save(serviceRecord);
    }

    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordRepository.findAll();
    }

    public List<ServiceRecord> getServiceRecordsByCar(Long carId) {
        return serviceRecordRepository.findByCarId(carId);
    }
}