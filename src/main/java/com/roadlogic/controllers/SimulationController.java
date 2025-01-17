package com.roadlogic.controllers;

import com.roadlogic.services.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulation")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    // Endpoint para iniciar a simulação
    @PostMapping("/start")
    public String startSimulation() {
        return simulationService.startSimulation();
    }

    // Endpoint para pausar a simulação
    @PostMapping("/pause")
    public String pauseSimulation() {
        return simulationService.pauseSimulation();
    }

    // Endpoint para simular o tráfego 
    @PostMapping("/run")
    public String simulateTraffic() {
        return simulationService.simulateTraffic();
    }

    // Endpoint para obter o status da simulação
    @GetMapping("/status")
    public String getSimulationStatus() {
        return simulationService.getSimulationStatus();
    }
}
