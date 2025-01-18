package com.roadlogic.models;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private double speed;
    private double maxSpeed;
    private double position;
    private String direction;
    private boolean emergency;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @ManyToOne
    @JoinColumn(name = "intersection_id")
    private Intersection intersection;

    // Construtor sem argumentos
    public Vehicle() {
    }

    // Construtor com argumentos
    public Vehicle(Long id, String name, String type, double speed, double maxSpeed, double position,
                   String direction, boolean emergency, Street street, Intersection intersection) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        this.position = position;
        this.direction = direction;
        this.emergency = emergency;
        this.street = street;
        this.intersection = intersection;
    }

    // Construtor simplificado para testes
    public Vehicle(Long id, String name, String type, double speed, double maxSpeed, boolean emergency) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.speed = speed;
    this.maxSpeed = maxSpeed;
    this.emergency = emergency;
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
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
    }
}
