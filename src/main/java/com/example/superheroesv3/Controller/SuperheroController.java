package com.example.superheroesv3.Controller;

import com.example.superheroesv3.Services.SuperheroService;
import com.example.superheroesv3.dto.SuperheroCityDTO;
import com.example.superheroesv3.dto.SuperheroDTO;
import com.example.superheroesv3.dto.SuperheroStrengthsDTO;
import com.example.superheroesv3.dto.SuperheroSuperpowerCountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getListOfSuperheroes(Model model) {
        List listOfSuperheroes = superheroService.getSuperheroes();
        model.addAttribute("superheroes",listOfSuperheroes);
        return "superheroes";
    }

    @GetMapping("/{name}")
    public String getSuperheroByName(@PathVariable String name, Model model) {
        SuperheroDTO superhero = superheroService.getSuperheroByName(name);
        model.addAttribute("superheroes",superhero);
        return "superheroes";
    }

    @GetMapping("/superpower/count")
    public String getSuperheroesPowerCount(Model model) {
        List superheroPowersCount = superheroService.getSuperheroesPowerCount();
        model.addAttribute("powercount", superheroPowersCount);
        return "powercount";
    }

    @GetMapping("/superpower/count/{name}")
    public String getSuperheroByNameAndPowerCount(@PathVariable String name, Model model) {
        SuperheroSuperpowerCountDTO superhero = superheroService.getSuperheroByNameAndPowerCount(name);
        model.addAttribute("powercount", superhero);
        return "powercount";
    }

    @GetMapping("/superpower")
    public String getSuperheroWithStrengths(Model model) {
        List superheroWithStrengths = superheroService.getSuperheroWithStrengths();
        model.addAttribute("superpower", superheroWithStrengths);
        return "superpower";
    }

    @GetMapping("/superpower/{name}")
    public String getSuperheroByNameAndWithStrengths(@PathVariable String name, Model model) {
        List superheroByNameAndWithStrengths = superheroService.getSuperheroByNameAndWithStrengths(name);
        model.addAttribute("superpower", superheroByNameAndWithStrengths);
        return "superpower";
    }

    @GetMapping("/city")
    public String getSuperheroAndCity(Model model) {
        List superheroAndCity = superheroService.getSuperheroAndCity();
        model.addAttribute("city", superheroAndCity);
        return "city";
    }

    @GetMapping("/city/{name}")
    public String getSuperheroAndCityByName(@PathVariable String name, Model model) {
        List cityByName = superheroService.getSuperheroAndCityByName(name);
        model.addAttribute("city", cityByName);
        return "city";
    }


}
