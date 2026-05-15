package com.cartracker.carservicetracker.repository;

import com.cartracker.carservicetracker.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByPlateNumberContainingIgnoreCaseOrOwnerNameContainingIgnoreCaseOrModelContainingIgnoreCase(
            String plateNumber,
            String ownerName,
            String model
    );
}
