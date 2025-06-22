package com.example.f1.dto;

public class TeamDTO {
    private Long id;
    private String name;
    private String baseCountry;

    public TeamDTO() {}

    public TeamDTO(Long id, String name, String baseCountry) {
        this.id = id;
        this.name = name;
        this.baseCountry = baseCountry;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBaseCountry() { return baseCountry; }
    public void setBaseCountry(String baseCountry) { this.baseCountry = baseCountry; }
}
