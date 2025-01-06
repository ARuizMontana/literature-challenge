package com.aruizmontana.literatura.ui.utils;


import com.aruizmontana.literatura.domain.response.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Locale;
import java.util.Scanner;

public class CustomConsole {
    private final Scanner scanner;

    public CustomConsole() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine().trim().toLowerCase(Locale.ROOT);
    }

    public int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public <E> void print(Result<E, String> result) {
        if (result.isSuccess()) {
            printHumanReadable(result.success().toString());
        } else {
            printHumanReadable(result.error());
        }
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void print() {
        print("\n");
    }

    private void printHumanReadable(String message) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            JsonElement json = JsonParser.parseString(message);
            print(gson.toJson(json));

        } catch (Exception e) {
            print(message);
        }
    }

    public void clean() {
        print("\033[H\033[2J");
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
