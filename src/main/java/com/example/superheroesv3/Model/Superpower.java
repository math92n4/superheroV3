package com.example.superheroesv3.Model;

public class Superpower {

    private String superPower;

    public Superpower(String superPower) {
        this.superPower = superPower;
    }

    public String getSuperPower() {
        return superPower;
    }

    @Override
    public String toString() {
        return this.superPower;
    }
}
