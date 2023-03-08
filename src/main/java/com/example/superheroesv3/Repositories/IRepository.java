package com.example.superheroesv3.Repositories;

import com.example.superheroesv3.dto.SuperheroCityDTO;
import com.example.superheroesv3.dto.SuperheroDTO;
import com.example.superheroesv3.dto.SuperheroStrengthsDTO;
import com.example.superheroesv3.dto.SuperheroSuperpowerCountDTO;

import java.util.List;

public interface IRepository {

    List<SuperheroDTO> getSuperheroes();
    SuperheroDTO getSuperheroByName(String superheroName);

    List<SuperheroSuperpowerCountDTO> getSuperheroesPowerCount();
    SuperheroSuperpowerCountDTO getSuperheroByNameAndPowerCount(String superheroName);

    List<SuperheroStrengthsDTO> getSuperheroWithStrengths();
    List<SuperheroStrengthsDTO> getSuperheroByNameAndWithStrengths(String superheroName);

    List<SuperheroCityDTO> getSuperheroAndCity();

}
