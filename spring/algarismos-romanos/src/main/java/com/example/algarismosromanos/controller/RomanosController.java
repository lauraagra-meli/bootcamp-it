package com.example.algarismosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romanos")
public class RomanosController {

    @GetMapping("/number/{number}")
    public String getRomanoNumber(@PathVariable int number) {

    }
}
