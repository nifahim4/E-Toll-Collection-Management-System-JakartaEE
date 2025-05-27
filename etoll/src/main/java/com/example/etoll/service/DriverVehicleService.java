package com.example.etoll.service;

import com.example.etoll.entity.DriverVehicle;
import com.example.etoll.repo.DriverVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DriverVehicleService {
    @Autowired
    private DriverVehicleRepository repo;

    public DriverVehicle save(DriverVehicle dv) {
        dv.setDate(LocalDateTime.now());
        return repo.save(dv);
    }

    public List<DriverVehicle> listAll() { return repo.findAll(); }

    public Optional<DriverVehicle> findById(Integer id) { return repo.findById(id); }

    public void deleteById(Integer id) { repo.deleteById(id); }

    public List<DriverVehicle> searchByDate(LocalDateTime from, LocalDateTime to) {
        return repo.findByDateBetween(from, to);
    }
}