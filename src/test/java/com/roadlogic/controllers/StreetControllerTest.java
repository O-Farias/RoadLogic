package com.roadlogic.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadlogic.models.Street;
import com.roadlogic.services.StreetService;
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

@WebMvcTest(StreetController.class)
class StreetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StreetService streetService;

    @Autowired
    private ObjectMapper objectMapper;

    private Street mockStreet;

    @BeforeEach
    void setUp() {
        mockStreet = new Street(1L, "Rua Principal", 500, null, null);
    }

    @Test
    void testGetAllStreets() throws Exception {
        when(streetService.getAllStreets()).thenReturn(List.of(mockStreet));

        mockMvc.perform(get("/streets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(mockStreet.getId()))
                .andExpect(jsonPath("$[0].name").value(mockStreet.getName()));

        verify(streetService, times(1)).getAllStreets();
    }

    @Test
    void testAddStreet() throws Exception {
        when(streetService.addStreet(any(Street.class))).thenReturn(mockStreet);

        mockMvc.perform(post("/streets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockStreet)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockStreet.getId()))
                .andExpect(jsonPath("$.name").value(mockStreet.getName()));

        verify(streetService, times(1)).addStreet(any(Street.class));
    }

    @Test
    void testGetStreetById() throws Exception {
        when(streetService.getStreetById(1L)).thenReturn(Optional.of(mockStreet));

        mockMvc.perform(get("/streets/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockStreet.getId()))
                .andExpect(jsonPath("$.name").value(mockStreet.getName()));

        verify(streetService, times(1)).getStreetById(1L);
    }

    @Test
    void testUpdateStreet() throws Exception {
        when(streetService.updateStreet(eq(1L), any(Street.class))).thenReturn(mockStreet);

        mockMvc.perform(put("/streets/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockStreet)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockStreet.getId()))
                .andExpect(jsonPath("$.name").value(mockStreet.getName()));

        verify(streetService, times(1)).updateStreet(eq(1L), any(Street.class));
    }

    @Test
    void testDeleteStreet() throws Exception {
        doNothing().when(streetService).deleteStreet(1L);

        mockMvc.perform(delete("/streets/1"))
                .andExpect(status().isOk());

        verify(streetService, times(1)).deleteStreet(1L);
    }
}
