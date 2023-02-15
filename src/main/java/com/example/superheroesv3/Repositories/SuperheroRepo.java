package com.example.superheroesv3.Repositories;
import com.example.superheroesv3.Model.Superhero;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepo {

    private List<Superhero> superheroes = List.of(new Superhero("Brian",
            "Laudrupfinten",
            "Brian Laudrup",
            1965,
            true,
            200),
            new Superhero("Messi",
            "Messithings",
                    "Lionel Messi",
                    1980,
                    true,
                    250));


    public Superhero createSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        return superhero;
    }

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchSuperhero(String superheroName) {
        Superhero superhero = null;
        for (Superhero superheroLoop : superheroes) {
            if (superheroLoop.getSuperheroName().equalsIgnoreCase(superheroName)) {
                superhero = superheroLoop;
            }
        }
        return superhero;
    }

    public Superhero editSuperhero(Superhero superhero) {
        int i=0;
        while (i<superheroes.size()) {
            if (superhero.getSuperheroName() == superheroes.get(i).getSuperheroName()) {
                superheroes.set(i, superhero);
                return superhero;
            }
            i++;
        }
        return null;
    }

    public Superhero deleteSuperhero(Superhero superhero) {
        Superhero superheroToRemove = searchSuperhero(superhero.getSuperheroName());
        superheroes.remove(superheroToRemove);
        return superheroToRemove;
    }


}




