package com.roadlogic.services;

import com.roadlogic.models.Vehicle;
import com.roadlogic.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) { 
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        return vehicleRepository.findById(id)
                .map(existingVehicle -> {
                    existingVehicle.setType(vehicle.getType());
                    existingVehicle.setSpeed(vehicle.getSpeed());
                    existingVehicle.setMaxSpeed(vehicle.getMaxSpeed());
                    existingVehicle.setPosition(vehicle.getPosition());
                    existingVehicle.setDirection(vehicle.getDirection());
                    existingVehicle.setEmergency(vehicle.isEmergency());
                    return vehicleRepository.save(existingVehicle);
                })
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
