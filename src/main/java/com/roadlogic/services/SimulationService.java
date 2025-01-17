package com.roadlogic.services;

import com.roadlogic.models.Street;
import com.roadlogic.models.Vehicle;
import com.roadlogic.models.Intersection;
import com.roadlogic.repositories.StreetRepository;
import com.roadlogic.repositories.VehicleRepository;
import com.roadlogic.repositories.IntersectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulationService {

    private boolean isSimulationRunning = false;

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private IntersectionRepository intersectionRepository;

    // Inicia a simulação
    public String startSimulation() {
        if (isSimulationRunning) {
            return "A simulação já está em execução!";
        }
        isSimulationRunning = true;
        return "Simulação iniciada com sucesso!";
    }

    // Pausa a simulação
    public String pauseSimulation() {
        if (!isSimulationRunning) {
            return "A simulação já está pausada!";
        }
        isSimulationRunning = false;
        return "Simulação pausada com sucesso!";
    }

    // Simula o movimento dos veículos
    public String simulateTraffic() {
        if (!isSimulationRunning) {
            return "A simulação não está em execução. Inicie a simulação primeiro!";
        }

        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle vehicle : vehicles) {
            
            System.out.println("Veículo " + vehicle.getId() + " está se movendo...");
        }

        return "Simulação executada com sucesso!";
    }

    // Retorna o status da simulação
    public String getSimulationStatus() {
        return isSimulationRunning ? "Simulação está em execução." : "Simulação está pausada.";
    }
}
