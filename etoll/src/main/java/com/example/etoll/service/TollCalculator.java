package com.example.etoll.service;

import org.springframework.stereotype.Component;

@Component
public class TollCalculator {

    public String calculateToll(String vehicleType) {
        switch (vehicleType) {
            case "Motorcycle": return "Collect 100 Taka";
            case "Car/JEEP": return "Collect 750 Taka";
            case "Pickup": return "Collect 1200 Taka";
            case "Microbus": return "Collect 1300 Taka";
            case "Truck(up to 5 tonnes)": return "Collect 2000 Taka";
            case "Truck(5-10 tonnes)": return "Collect 2500 Taka";
            case "Truck(10-15 tonnes)": return "Collect 3000 Taka";
            case "MINI-Bus": return "Collect 1400 Taka";
            case "MEDIUM-Bus": return "Collect 2000 Taka";
            case "LARGE-Bus": return "Collect 2700 Taka";
            case "Trailer": return "Collect 3500 Taka";
            default: return "Unknown vehicle type";
        }
    }
}