package com.example.superheroesv3.dto;

import com.example.superheroesv3.Model.Superpower;

import java.util.ArrayList;
import java.util.List;

public class SuperheroStrengthsDTO {

    private int id;
    private String superheroName;
    private String realName;
    private List<Superpower> superpowers;

    public SuperheroStrengthsDTO(int id, String superheroName, String realName, List<Superpower> superpowers) {
        this.id = id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowers = superpowers;
    }

    public void addPower(Superpower superpower) {
        superpowers.add(superpower);
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

    public List<Superpower> getSuperpowers() {
        return superpowers;
    }
}
