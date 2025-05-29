package com.example.etoll.service;

import com.example.etoll.entity.DriverVehicle;
import com.example.etoll.repo.DriverVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverVehicleService {

    @Autowired
    private DriverVehicleRepository repository;

    public DriverVehicle save(DriverVehicle dv) {
        dv.setDate(LocalDateTime.now());
        return repository.save(dv);
    }

    public List<DriverVehicle> listAll() {
        return repository.findAll();
    }

    public Optional<DriverVehicle> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<DriverVehicle> searchByDate(LocalDate from, LocalDate to) {
        LocalDateTime fromDateTime = from.atStartOfDay();
        LocalDateTime toDateTime = to.atTime(LocalTime.MAX);
        return repository.findByDateBetween(fromDateTime, toDateTime);
    }
}