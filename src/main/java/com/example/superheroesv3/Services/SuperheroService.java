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

    public void createSuperhero(String superheroName, String superPowers, String realName, int yearCreated, boolean isHuman, double strength) {
        superheroRepo.createSuperhero(superheroName,superPowers,realName,yearCreated,isHuman,strength);
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepo.getSuperheroes();
    }

    public Superhero searchSuperhero(String superheroName) {
        return superheroRepo.searchSuperhero(superheroName);
    }

    public void editSuperhero(int index, String superheroName, String superPowers, String realName, int yearCreated, boolean isHuman, double strength) {
        superheroRepo.editSuperhero(index,superheroName,superPowers,realName,yearCreated,isHuman,strength);
    }

    public void deleteSuperhero(int index) {
        superheroRepo.deleteSuperhero(index);
    }





}
