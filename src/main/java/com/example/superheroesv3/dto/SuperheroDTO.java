package com.example.superheroesv3.dto;

public class SuperheroDTO {

    private int id;
    private String superheroName;
    private String realName;
    private String yearCreated;

    public SuperheroDTO(int id, String superheroName, String realName, String yearCreated) {
        this.id = id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.yearCreated = yearCreated;
    }

    public int getId() {
        return id;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getYearCreated() {
        return yearCreated;
    }
}
