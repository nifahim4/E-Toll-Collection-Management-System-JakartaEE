package com.example.etoll.controller;

import com.example.etoll.entity.DriverVehicle;
import com.example.etoll.service.DriverVehicleService;
import com.example.etoll.service.TollCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class DriverVehicleController {
    @Autowired
    private DriverVehicleService service;

    @Autowired
    private TollCalculator tollCalculator;

    @GetMapping
    public List<DriverVehicle> list() {
        return service.listAll();
    }

    @PostMapping
    public String add(@RequestBody DriverVehicle dv) {
        service.save(dv);
        return tollCalculator.getTollMessage(dv.getVehicleType());
    }

    @PutMapping("/{id}")
    public DriverVehicle update(@PathVariable Integer id, @RequestBody DriverVehicle dv) {
        dv.setId(id);
        return service.save(dv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/search")
    public List<DriverVehicle> search(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return service.searchByDate(from, to);
    }
}