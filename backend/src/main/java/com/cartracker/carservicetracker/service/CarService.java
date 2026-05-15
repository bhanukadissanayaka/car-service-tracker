package com.cartracker.carservicetracker.service;

import com.cartracker.carservicetracker.model.Car;
import com.cartracker.carservicetracker.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> searchCars(String keyword) {
        return carRepository
                .findByPlateNumberContainingIgnoreCaseOrOwnerNameContainingIgnoreCaseOrModelContainingIgnoreCase(
                        keyword, keyword, keyword
                );
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}