package com.example.superheroesv3.Model;

public class Superhero {

    private int id;
    private String superheroName;
    private String superPowers;
    private String realName;
    private String yearCreated;
    private String isHuman;
    private double strength;


    public Superhero(int id, String superheroName,String superPowers,String realName,String yearCreated,String isHuman,double strength) {
        this.id = id;
        this.superheroName = superheroName;
        this.superPowers = superPowers;
        this.realName = realName;
        this.yearCreated = yearCreated;
        this.isHuman = isHuman;
        this.strength = strength;
    }


    public int getId() {
        return id;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getSuperPowers() {
        return superPowers;
    }

    public String getRealName() {
        return realName;
    }

    public String getYearCreated() {
        return yearCreated;
    }

    public String isHuman() {
        return isHuman;
    }

    public double getStrength() {
        return strength;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setSuperPowers(String superPowers) {
        this.superPowers = superPowers;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setYearCreated(String yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public String toString() {
        return "\n" + "--------------------" + "\n" + "SUPERHERO #" + "\n" + "--------------------"
                + "\n" + "Superhero name: " + superheroName + "\n" + "Super powers: "
                + superPowers + "\n" + "Real name: " + realName + "\n"
                + "Year created: " + yearCreated + "\n" +
                "Is human? " + isHuman + "\n" + "Strength: " + strength + "\n";
    }

}