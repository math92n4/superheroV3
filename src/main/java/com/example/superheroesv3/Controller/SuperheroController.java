package com.example.superheroesv3.Controller;

import com.example.superheroesv3.Model.Superhero;
import com.example.superheroesv3.Services.SuperheroService;
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
    public ResponseEntity<String> searchForSuperhero(@PathVariable String name) {
        Superhero superhero = superheroService.searchSuperhero(name);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/html");

        return new ResponseEntity<>(
                "<html><body><h1>" +
                        superhero.getSuperheroName() +
                        superhero.getSuperPowers() +
                        superhero.getRealName() +
                        superhero.getYearCreated() +
                        superhero.isHuman() +
                        superhero.getStrength() +
                        "</h1><body></html>", responseHeaders, HttpStatus.OK
        );

        // return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @PostMapping("/create/")
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.createSuperhero(superhero);
        return new ResponseEntity<>(returnSuperhero, HttpStatus.OK);
    }

    @PutMapping("/edit/")
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.editSuperhero(superhero);
        return new ResponseEntity<>(returnSuperhero, HttpStatus.OK);
    }


    @DeleteMapping("/delete/")
    public ResponseEntity<Superhero> deleteSuperhero(@RequestBody Superhero superhero) {
        Superhero deleteSuperhero = superheroService.deleteSuperhero(superhero);
        return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
    }




}
