package com.example.superheroesv3.Repositories;
import com.example.superheroesv3.Model.Superhero;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepo {

    private boolean changeMade = false;
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



    public void createSuperhero(String superheroName, String superPowers, String realName, int yearCreated, boolean isHuman, double strength) {
        Superhero superhero = new Superhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
        superheroes.add(superhero);
        changeBeenMade();
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

    public void editSuperhero(int index, String superheroName, String superPowers, String realName, int yearCreated, boolean isHuman, double strength) {
        Superhero superhero = superheroes.get(index - 1);
        if (!superheroName.isEmpty()) {
            superhero.setSuperheroName(superheroName);
            changeBeenMade();
        }

        if (!superPowers.isEmpty()) {
            superhero.setSuperPowers(superPowers);
            changeBeenMade();
        }

        if (!realName.isEmpty()) {
            superhero.setRealName(realName);
            changeBeenMade();
        }

        if (yearCreated != 0) {
            superhero.setYearCreated(yearCreated);
            changeBeenMade();
        }

        if (strength != 0) {
            superhero.setStrength(strength);
            changeBeenMade();
        }

        superhero.setIsHuman(isHuman);
    }

    public void deleteSuperhero(int index) {
        Superhero superhero = superheroes.get(index - 1);
        superheroes.remove(superhero);
        changeBeenMade();
    }

    public void changeBeenMade() {
        changeMade = true;
    }

    public void changeNotMade() {
        changeMade = false;

    }

    public boolean getChangeMade() {
        return changeMade;
    }


}




