package com.example.superheroesv3.dto;

public class SuperheroSuperpowerCountDTO {

    private int id;
    private String superheroName;
    private String realName;
    private int superpowerCount;

    public SuperheroSuperpowerCountDTO(int id, String superheroName, String realName, int superpowerCount) {
        this.id = id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowerCount = superpowerCount;
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

    public int getSuperpowerCount() {
        return superpowerCount;
    }
}
