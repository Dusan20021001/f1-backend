package com.example.f1.service;

import com.example.f1.dto.TeamDTO;
import com.example.f1.entity.Team;
import com.example.f1.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
            .map(t -> new TeamDTO(t.getId(), t.getName(), t.getBaseCountry()))
            .collect(Collectors.toList());
    }

    public TeamDTO getTeam(Long id) {
        return teamRepository.findById(id)
            .map(t -> new TeamDTO(t.getId(), t.getName(), t.getBaseCountry()))
            .orElse(null);
    }

    public Team createTeam(TeamDTO dto) {
        Team team = new Team();
        team.setName(dto.getName());
        team.setBaseCountry(dto.getBaseCountry());
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, TeamDTO dto) {
        return teamRepository.findById(id).map(team -> {
            team.setName(dto.getName());
            team.setBaseCountry(dto.getBaseCountry());
            return teamRepository.save(team);
        }).orElse(null);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}