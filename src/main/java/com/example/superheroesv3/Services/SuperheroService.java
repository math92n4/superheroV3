package com.example.superheroesv3.Services;


import com.example.superheroesv3.Repositories.SuperheroRepoDB;
import com.example.superheroesv3.dto.SuperheroDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuperheroService {

    private SuperheroRepoDB superheroRepoDB;

    public SuperheroService(SuperheroRepoDB superheroRepoDB) {
        this.superheroRepoDB = superheroRepoDB;
    }

    public List<SuperheroDTO> getSuperheroes() {
        return superheroRepoDB.getSuperheroes();
    }

    public SuperheroDTO getSuperheroByName(String superheroName) {
        return superheroRepoDB.getSuperheroByName(superheroName);
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
