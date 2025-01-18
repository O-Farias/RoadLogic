package com.roadlogic.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadlogic.models.Vehicle;
import com.roadlogic.services.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleService;

    @Autowired
    private ObjectMapper objectMapper;

    private Vehicle mockVehicle;

    @BeforeEach
    void setUp() {
        mockVehicle = new Vehicle(1L, "Carro 1", "Car", 60.0, 120.0, 0.0, "Norte", false, null, null);
    }

    @Test
    void testGetAllVehicles() throws Exception {
        when(vehicleService.getAllVehicles()).thenReturn(List.of(mockVehicle));

        mockMvc.perform(get("/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(mockVehicle.getId()))
                .andExpect(jsonPath("$[0].name").value(mockVehicle.getName()));

        verify(vehicleService, times(1)).getAllVehicles();
    }

   @Test
    void testAddVehicle() throws Exception {
    // Configura o mock para retornar um veículo com ID definido
        Vehicle mockResponseVehicle = new Vehicle(1L, "Carro 1", "Car", 60.0, 120.0, 0.0, "Norte", false, null, null);
        when(vehicleService.addVehicle(any(Vehicle.class))).thenReturn(mockResponseVehicle);

        // Envia um veículo e espera o retorno com o ID no JSON
        mockMvc.perform(post("/vehicles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(mockVehicle)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(mockResponseVehicle.getId())) 
            .andExpect(jsonPath("$.name").value(mockResponseVehicle.getName())); 

        verify(vehicleService, times(1)).addVehicle(any(Vehicle.class));
    }



    @Test
    void testGetVehicleById() throws Exception {
        when(vehicleService.getVehicleById(1L)).thenReturn(Optional.of(mockVehicle));

        mockMvc.perform(get("/vehicles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockVehicle.getId()))
                .andExpect(jsonPath("$.name").value(mockVehicle.getName()));

        verify(vehicleService, times(1)).getVehicleById(1L);
    }

    @Test
    void testUpdateVehicle() throws Exception {
        when(vehicleService.updateVehicle(eq(1L), any(Vehicle.class))).thenReturn(mockVehicle);

        mockMvc.perform(put("/vehicles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockVehicle)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockVehicle.getId()))
                .andExpect(jsonPath("$.name").value(mockVehicle.getName()));

        verify(vehicleService, times(1)).updateVehicle(eq(1L), any(Vehicle.class));
    }

    @Test
    void testDeleteVehicle() throws Exception {
        doNothing().when(vehicleService).deleteVehicle(1L);

        mockMvc.perform(delete("/vehicles/1"))
                .andExpect(status().isOk());

        verify(vehicleService, times(1)).deleteVehicle(1L);
    }
}
