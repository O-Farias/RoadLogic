package com.roadlogic.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadlogic.models.Intersection;
import com.roadlogic.services.IntersectionService;
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

@WebMvcTest(IntersectionController.class)
class IntersectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IntersectionService intersectionService;

    @Autowired
    private ObjectMapper objectMapper;

    private Intersection mockIntersection;

    @BeforeEach
    void setUp() {
        mockIntersection = new Intersection(1L, "Cruzamento", "Intersection Type", "Verde", 1.0, 1.0, 10, null, null);
    }

    @Test
    void testGetAllIntersections() throws Exception {
        when(intersectionService.getAllIntersections()).thenReturn(List.of(mockIntersection));

        mockMvc.perform(get("/intersections"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(mockIntersection.getId()))
                .andExpect(jsonPath("$[0].name").value(mockIntersection.getName()));

        verify(intersectionService, times(1)).getAllIntersections();
    }

    @Test
    void testAddIntersection() throws Exception {
        when(intersectionService.saveIntersection(any(Intersection.class))).thenReturn(mockIntersection);

        mockMvc.perform(post("/intersections")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockIntersection)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockIntersection.getId()))
                .andExpect(jsonPath("$.name").value(mockIntersection.getName()));

        verify(intersectionService, times(1)).saveIntersection(any(Intersection.class));
    }

    @Test
    void testGetIntersectionById() throws Exception {
        when(intersectionService.getIntersectionById(1L)).thenReturn(Optional.of(mockIntersection));

        mockMvc.perform(get("/intersections/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockIntersection.getId()))
                .andExpect(jsonPath("$.name").value(mockIntersection.getName()));

        verify(intersectionService, times(1)).getIntersectionById(1L);
    }

    @Test
    void testUpdateIntersection() throws Exception {
        when(intersectionService.updateIntersection(eq(1L), any(Intersection.class))).thenReturn(mockIntersection);

        mockMvc.perform(put("/intersections/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(mockIntersection)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(mockIntersection.getId()))
                .andExpect(jsonPath("$.name").value(mockIntersection.getName()));

        verify(intersectionService, times(1)).updateIntersection(eq(1L), any(Intersection.class));
    }

    @Test
    void testDeleteIntersection() throws Exception {
        doNothing().when(intersectionService).deleteIntersection(1L);

        mockMvc.perform(delete("/intersections/1"))
                .andExpect(status().isOk());

        verify(intersectionService, times(1)).deleteIntersection(1L);
    }
}
