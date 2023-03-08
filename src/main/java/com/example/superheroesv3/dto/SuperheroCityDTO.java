package com.example.superheroesv3.dto;

import com.example.superheroesv3.Model.City;

import java.util.ArrayList;
import java.util.List;

public class SuperheroCityDTO {

    private City city;
    private List<SuperheroDTO> superheroes;

    public SuperheroCityDTO(City city, ArrayList<SuperheroDTO> superheroes) {
        this.city = city;
        this.superheroes = superheroes;
    }

    public void addHero(SuperheroDTO superhero) {
        superheroes.add(superhero);
    }

    public City getCity() {
        return city;
    }

    public List<SuperheroDTO> getSuperheroes() {
        return superheroes;
    }
}
