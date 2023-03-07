package com.example.superheroesv3.dto;

import java.util.ArrayList;

public class SuperheroStrengthsDTO {

    private int id;
    private String superheroName;
    private String realName;
    private ArrayList<String> superpowers;

    public SuperheroStrengthsDTO(int id, String superheroName, String realName, ArrayList<String> superpowers) {
        this.id = id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowers = superpowers;
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

    public ArrayList<String> getSuperpowers() {
        return superpowers;
    }
}
