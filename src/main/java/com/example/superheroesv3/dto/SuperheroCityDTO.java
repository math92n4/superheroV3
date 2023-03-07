package com.example.superheroesv3.dto;

import java.util.ArrayList;
import java.util.List;

public class SuperheroCityDTO {

    private int id;
    private String city;
    private ArrayList<String> superheroNames;

    public SuperheroCityDTO(int id, ArrayList<String> superheroNames, String city) {
        this.id = id;
        this.superheroNames = superheroNames;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getSuperheroNames() {
        return superheroNames;
    }

    public String getCity() {
        return city;
    }
}
