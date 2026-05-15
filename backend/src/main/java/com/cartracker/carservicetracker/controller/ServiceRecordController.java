package com.cartracker.carservicetracker.controller;

import com.cartracker.carservicetracker.model.ServiceRecord;
import com.cartracker.carservicetracker.service.ServiceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "*")
public class ServiceRecordController {

    private final ServiceRecordService serviceRecordService;

    public ServiceRecordController(ServiceRecordService serviceRecordService) {
        this.serviceRecordService = serviceRecordService;
    }

    @PostMapping("/car/{carId}")
    public ServiceRecord addServiceRecord(@PathVariable Long carId,
                                          @RequestBody ServiceRecord serviceRecord) {
        return serviceRecordService.addServiceRecord(carId, serviceRecord);
    }

    @GetMapping
    public List<ServiceRecord> getAllServiceRecords() {
        return serviceRecordService.getAllServiceRecords();
    }

    @GetMapping("/car/{carId}")
    public List<ServiceRecord> getServiceRecordsByCar(@PathVariable Long carId) {
        return serviceRecordService.getServiceRecordsByCar(carId);
    }
}