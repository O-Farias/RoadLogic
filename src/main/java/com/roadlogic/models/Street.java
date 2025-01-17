package com.roadlogic.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double length;

    private String type; 

    private int maxSpeed; 

    private String condition; 

    private String trafficFlow; 

    private boolean isOneWay; 

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Intersection> intersections;

    @OneToMany(mappedBy = "street", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getTrafficFlow() {
        return trafficFlow;
    }

    public void setTrafficFlow(String trafficFlow) {
        this.trafficFlow = trafficFlow;
    }

    public boolean isOneWay() {
        return isOneWay;
    }

    public void setOneWay(boolean oneWay) {
        isOneWay = oneWay;
    }
}
