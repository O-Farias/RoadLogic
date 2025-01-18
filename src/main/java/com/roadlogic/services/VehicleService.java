package com.roadlogic.services;

import com.roadlogic.models.Vehicle;
import com.roadlogic.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityNotFoundException;


@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) { 
        return vehicleRepository.save(vehicle);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
    Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(id);
    if (existingVehicleOpt.isPresent()) {
        Vehicle existingVehicle = existingVehicleOpt.get();
        // Atualiza os campos
        existingVehicle.setName(updatedVehicle.getName());
        existingVehicle.setType(updatedVehicle.getType());
        existingVehicle.setSpeed(updatedVehicle.getSpeed());
        existingVehicle.setMaxSpeed(updatedVehicle.getMaxSpeed());
        existingVehicle.setEmergency(updatedVehicle.isEmergency());
        // Salva as mudanças
        return vehicleRepository.save(existingVehicle);
    } else {
        throw new EntityNotFoundException("Vehicle not found");
    }
}


    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
