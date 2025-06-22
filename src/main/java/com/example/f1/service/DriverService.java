package com.example.f1.service;

import com.example.f1.dto.DriverDTO;
import com.example.f1.entity.Driver;
import com.example.f1.entity.Team;
import com.example.f1.repository.DriverRepository;
import com.example.f1.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;

    public DriverService(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream()
            .map(driver -> {
                Team team = driver.getTeam();
                return new DriverDTO(
                    driver.getId(),
                    driver.getName(),
                    driver.getNumber(),
                    team != null ? team.getId() : null,
                    team != null ? team.getName() : null
                );
            })
            .collect(Collectors.toList());
    }

    public DriverDTO getDriver(Long id) {
        return driverRepository.findById(id)
            .map(driver -> {
                Team team = driver.getTeam();
                return new DriverDTO(
                    driver.getId(),
                    driver.getName(),
                    driver.getNumber(),
                    team != null ? team.getId() : null,
                    team != null ? team.getName() : null
                );
            })
            .orElse(null);
    }

    public Driver createDriver(DriverDTO dto) {
        Driver driver = new Driver();
        driver.setName(dto.getName());
        driver.setNumber(dto.getNumber());
        if (dto.getTeamId() != null) {
            Team team = teamRepository.findById(dto.getTeamId()).orElse(null);
            driver.setTeam(team);
        }
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, DriverDTO dto) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(dto.getName());
            driver.setNumber(dto.getNumber());
            if (dto.getTeamId() != null) {
                Team team = teamRepository.findById(dto.getTeamId()).orElse(null);
                driver.setTeam(team);
            } else {
                driver.setTeam(null);
            }
            return driverRepository.save(driver);
        }).orElse(null);
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
