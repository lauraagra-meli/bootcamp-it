package com.example.exemplo.dto;
// MODELO PRA TRANFERIR DADOS

import com.example.exemplo.controller.User;

public class UserDto {
    private String name;

    // quero mandar só o nome
    public UserDto(User user) {
        this.name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
