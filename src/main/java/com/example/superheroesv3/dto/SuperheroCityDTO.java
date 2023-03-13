package com.example.superheroesv3.dto;

public class SuperheroCityDTO {

    private String cityName;
    private String superheroName;
    private String realName;
    private String yearCreated;

    public SuperheroCityDTO(String cityName, String superheroName, String realName, String yearCreated) {
        this.cityName = cityName;
        this.superheroName = superheroName;
        this.realName = realName;
        this.yearCreated = yearCreated;
    }


    public String getSuperheroName() {
        return superheroName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getRealName() {
        return realName;
    }

    public String getYearCreated() {
        return yearCreated;
    }
}
