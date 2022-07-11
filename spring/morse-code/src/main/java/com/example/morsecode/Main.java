package com.example.morsecode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Main {

    MorseCode morseCode = new MorseCode();

    @GetMapping("/code/{code}")
    public String convertCode(@PathVariable String code) {
        return morseCode.convertedCode(code);
    }
}
