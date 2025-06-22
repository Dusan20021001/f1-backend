package com.example.f1.dto;

public class DriverDTO {
    private Long id;
    private String name;
    private int number;
    private Long teamId;
    private String teamName;

    public DriverDTO() {}

    public DriverDTO(Long id, String name, int number, Long teamId, String teamName) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.teamId = teamId;
        this.teamName = teamName;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
}
