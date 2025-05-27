package com.example.etoll.service;

import org.springframework.stereotype.Component;

@Component
public class TollCalculator {
    public String getTollMessage(String vehicleType) {
        return switch (vehicleType) {
            case "Motorcycle" -> "Collect\n 100 Taka";
            case "Car/JEEP" -> "Collect\n 750 Taka";
            case "Pickup" -> "Collect\n 1,200 Taka";
            case "Microbus" -> "Collect\n 1,300 Taka";
            case "Truck(up to 5 tonnes)" -> "Collect\n 2,000 Taka";
            case "Truck(5-10 tonnes)" -> "Collect\n 3,000 Taka";
            case "Truck(10-15 tonnes)" -> "Collect\n 4,000 Taka";
            case "MINI-Bus" -> "Collect\n 1,400 Taka";
            case "MEDIUM-Bus" -> "Collect\n 2,000 Taka";
            case "LARGE-Bus" -> "Collect\n 2,400 Taka";
            case "Trailer" -> "Collect\n 5,000 Taka";
            default -> "Collect\n 0 Taka";
        };
    }
}