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
    private double coordinatesX;
    private double coordinatesY;
    private int maxVehicles;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "intersection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

    // Construtor sem argumentos
    public Intersection() {
    }

    // Construtor com argumentos
    public Intersection(Long id, String name, String type, String trafficLight, double coordinatesX,
                        double coordinatesY, int maxVehicles, Street street, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.trafficLight = trafficLight;
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.maxVehicles = maxVehicles;
        this.street = street;
        this.vehicles = vehicles;
    }

    // Construtor simplificado para testes
    public Intersection(Long id, String name, String type, String trafficLight, double coordinatesX, double coordinatesY, int maxVehicles) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.trafficLight = trafficLight;
    this.coordinatesX = coordinatesX;
    this.coordinatesY = coordinatesY;
    this.maxVehicles = maxVehicles;
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

    public double getCoordinatesX() {
        return coordinatesX;
    }

    public void setCoordinatesX(double coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public double getCoordinatesY() {
        return coordinatesY;
    }

    public void setCoordinatesY(double coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public int getMaxVehicles() {
        return maxVehicles;
    }

    public void setMaxVehicles(int maxVehicles) {
        this.maxVehicles = maxVehicles;
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
