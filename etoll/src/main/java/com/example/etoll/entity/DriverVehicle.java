package com.example.etoll.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "etoll")
public class DriverVehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String driverName;
    private String driverLisence;
    private String vehicleNumber;
    private String vehicleModel;
    private String vehicleType;
    private LocalDateTime date;

    public DriverVehicle() {
    }

    public DriverVehicle(Integer id, String driverName, String driverLisence, String vehicleNumber, String vehicleModel, String vehicleType, LocalDateTime date) {
        this.id = id;
        this.driverName = driverName;
        this.driverLisence = driverLisence;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLisence() {
        return driverLisence;
    }

    public void setDriverLisence(String driverLisence) {
        this.driverLisence = driverLisence;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}