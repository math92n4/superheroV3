package com.example.superheroesv3.Services;


import com.example.superheroesv3.Repositories.SuperheroRepoDB;
import com.example.superheroesv3.dto.SuperheroCityDTO;
import com.example.superheroesv3.dto.SuperheroDTO;
import com.example.superheroesv3.dto.SuperheroStrengthsDTO;
import com.example.superheroesv3.dto.SuperheroSuperpowerCountDTO;
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

    public List<SuperheroSuperpowerCountDTO> getSuperheroesPowerCount() {
        return superheroRepoDB.getSuperheroesPowerCount();
    }

    public SuperheroSuperpowerCountDTO getSuperheroByNameAndPowerCount(String superheroName) {
        return superheroRepoDB.getSuperheroByNameAndPowerCount(superheroName);
    }

    public List<SuperheroStrengthsDTO> getSuperheroWithStrengths () {
        return superheroRepoDB.getSuperheroWithStrengths();
    }

    public List<SuperheroStrengthsDTO> getSuperheroByNameAndWithStrengths(String superheroName) {
        return superheroRepoDB.getSuperheroByNameAndWithStrengths(superheroName);
    }

    public List<SuperheroCityDTO> getSuperheroAndCity() {
        return superheroRepoDB.getSuperheroAndCity();
    }

    public List<SuperheroCityDTO> getSuperheroAndCityByName(String name) {
        return superheroRepoDB.getSuperheroAndCityByName(name);
    }



}
