package com.aruizmontana.literatura.domain.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class PersonModel extends Printable {
    private String name;
    @SerializedName("birth_year")
    private int birthYear;
    @SerializedName("death_year")
    private int deathYear;

    public PersonModel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
