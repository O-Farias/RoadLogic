package com.roadlogic.models;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; 

    private double speed; 

    private double maxSpeed; 

    private double position; 

    private String direction; 

    private boolean isEmergency; 

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public void setEmergency(boolean emergency) {
        isEmergency = emergency;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
