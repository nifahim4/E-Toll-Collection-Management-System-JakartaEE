package com.example.etoll.repo;

import com.example.etoll.entity.DriverVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DriverVehicleRepository extends JpaRepository<DriverVehicle, Integer> {
    List<DriverVehicle> findByDateBetween(LocalDateTime from, LocalDateTime to);
}