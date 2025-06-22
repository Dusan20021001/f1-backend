package com.example.f1.controller;

import com.example.f1.dto.DriverDTO;
import com.example.f1.entity.Driver;
import com.example.f1.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<DriverDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriver(@PathVariable Long id) {
        DriverDTO driver = driverService.getDriver(id);
        if (driver == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(driver);
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody DriverDTO dto) {
        Driver saved = driverService.createDriver(dto);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody DriverDTO dto) {
        Driver updated = driverService.updateDriver(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}