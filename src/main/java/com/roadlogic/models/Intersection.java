package com.roadlogic.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Intersection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String trafficLight;

    private Double latitude;
    private Double longitude;
    private Integer trafficFlow;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "intersection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

    // Construtor sem argumentos
    public Intersection() {}

    // Construtor completo
    public Intersection(Long id, String name, String type, String trafficLight, Double latitude, Double longitude,
                        Integer trafficFlow, Street street, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.trafficLight = trafficLight;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trafficFlow = trafficFlow;
        this.street = street;
        this.vehicles = vehicles;
    }

    // Construtor simplificado para testes
    public Intersection(Long id, String name, String type, String trafficLight, Double latitude, Double longitude, Integer trafficFlow) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.trafficLight = trafficLight;
        this.latitude = latitude;
        this.longitude = longitude;
        this.trafficFlow = trafficFlow;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(String trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getTrafficFlow() {
        return trafficFlow;
    }

    public void setTrafficFlow(Integer trafficFlow) {
        this.trafficFlow = trafficFlow;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
