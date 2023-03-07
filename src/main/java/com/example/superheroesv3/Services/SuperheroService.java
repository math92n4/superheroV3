package com.example.superheroesv3.Services;

import com.example.superheroesv3.Model.Superhero;
import com.example.superheroesv3.Repositories.SuperheroRepo;
import com.example.superheroesv3.Repositories.SuperheroRepoDB;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuperheroService {

    private SuperheroRepoDB superheroRepoDB;

    public SuperheroService(SuperheroRepoDB superheroRepoDB) {
        this.superheroRepoDB = superheroRepoDB;
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepoDB.getSuperheroes();
    }


   /* public Superhero createSuperhero(Superhero superhero) {
        return superheroRepoDB.createSuperhero(superhero);
    }

    public Superhero searchSuperhero(String superheroName) {
        return superheroRepoDB.searchSuperhero(superheroName);
    }

    public Superhero editSuperhero(Superhero superhero) {
        return superheroRepoDB.editSuperhero(superhero);
    }

    public Superhero deleteSuperhero(Superhero superhero) {
        return superheroRepoDB.deleteSuperhero(superhero);
    }*/





}
