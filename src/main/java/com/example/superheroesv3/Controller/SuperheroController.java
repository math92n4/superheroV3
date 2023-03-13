package com.example.superheroesv3.Controller;

import com.example.superheroesv3.Model.Superhero;
import com.example.superheroesv3.Services.SuperheroService;
import com.example.superheroesv3.dto.SuperheroCityDTO;
import com.example.superheroesv3.dto.SuperheroDTO;
import com.example.superheroesv3.dto.SuperheroStrengthsDTO;
import com.example.superheroesv3.dto.SuperheroSuperpowerCountDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Superhero>> getListOfSuperheroes() {
        List listOfSuperheroes = superheroService.getSuperheroes();
        return new ResponseEntity<List<Superhero>>(listOfSuperheroes, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<SuperheroDTO> getSuperheroByName(@PathVariable String name) {
        SuperheroDTO superhero = superheroService.getSuperheroByName(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpower/count")
    public ResponseEntity<List<SuperheroSuperpowerCountDTO>> getSuperheroesPowerCount() {
        List superheroPowersCount = superheroService.getSuperheroesPowerCount();
        return new ResponseEntity<List<SuperheroSuperpowerCountDTO>>(superheroPowersCount,HttpStatus.OK);
    }

    @GetMapping("/superpower/count/{name}")
    public ResponseEntity<SuperheroSuperpowerCountDTO> getSuperheroByNameAndPowerCount(@PathVariable String name) {
        SuperheroSuperpowerCountDTO superhero = superheroService.getSuperheroByNameAndPowerCount(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpower")
    public ResponseEntity<List<SuperheroStrengthsDTO>> getSuperheroWithStrengths() {
        List superheroWithStrengths = superheroService.getSuperheroWithStrengths();
        return new ResponseEntity<List<SuperheroStrengthsDTO>>(superheroWithStrengths,HttpStatus.OK);
    }

    @GetMapping("/superpower/{name}")
    public ResponseEntity<List<SuperheroStrengthsDTO>> getSuperheroByNameAndWithStrengths(@PathVariable String name) {
        List superheroByNameAndWithStrengths = superheroService.getSuperheroByNameAndWithStrengths(name);
        return new ResponseEntity<List<SuperheroStrengthsDTO>>(superheroByNameAndWithStrengths,HttpStatus.OK);
    }

    @GetMapping("/city")
    public ResponseEntity<List<SuperheroCityDTO>> getSuperheroAndCity() {
        List superheroAndCity = superheroService.getSuperheroAndCity();
        return new ResponseEntity<List<SuperheroCityDTO>>(superheroAndCity, HttpStatus.OK);
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<SuperheroCityDTO> getSuperheroAndCityByName(@PathVariable String name) {
        SuperheroCityDTO cityByName = superheroService.getSuperheroAndCityByName(name);
        return new ResponseEntity<>(cityByName,HttpStatus.OK);
    }

    /*@PostMapping("/create/")
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.createSuperhero(superhero);
        return new ResponseEntity<>(returnSuperhero, HttpStatus.OK);
    }

    @PutMapping("/edit/")
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.editSuperhero(superhero);
        return new ResponseEntity<>(returnSuperhero, HttpStatus.OK);
    }*/


}
