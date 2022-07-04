package com.example.exemplo.controller;

public class User {
    private int id;
    private String name;

    // REGRA: Sempre precisa gerar um constructor sem parametros
    // spring - 1 chama o constrctor sem parametros e depois chama os getter and setter
    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return id + " - " + name;
    }
}
