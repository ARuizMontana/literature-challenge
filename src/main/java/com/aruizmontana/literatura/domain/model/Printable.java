package com.aruizmontana.literatura.domain.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class Printable {

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .create();
        return gson.toJson(this);
    }
}
