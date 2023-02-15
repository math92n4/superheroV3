package com.example.superheroesv3.Services;

import com.example.superheroesv3.Model.Superhero;
import com.example.superheroesv3.Repositories.SuperheroRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuperheroService {

    private SuperheroRepo superheroRepo;

    public SuperheroService(SuperheroRepo superheroRepo) {
        this.superheroRepo = new SuperheroRepo();
    }


    public Superhero createSuperhero(Superhero superhero) {
        return superheroRepo.createSuperhero(superhero);
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepo.getSuperheroes();
    }

    public Superhero searchSuperhero(String superheroName) {
        return superheroRepo.searchSuperhero(superheroName);
    }

    public Superhero editSuperhero(Superhero superhero) {
        return superheroRepo.editSuperhero(superhero);
    }

    public Superhero deleteSuperhero(Superhero superhero) {
        return superheroRepo.deleteSuperhero(superhero);
    }





}
