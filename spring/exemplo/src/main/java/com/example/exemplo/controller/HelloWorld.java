package com.example.exemplo.controller;

// CLASSE CONTROLLER

import com.example.exemplo.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // indica que essa classe é um controller Rest
@RequestMapping("/user") // indica que /user é usado para acionar esse controller (ENDPOINT)
public class HelloWorld {

    @GetMapping("/hello/{name}/{id}") // esse metodo é acionado por uma requisicao GET
    public String sayHello(@PathVariable String name, @PathVariable int id) { // variavel vem do path
        return "Hello " + name + " - " + id + "!";
    }

    // outro jeito
    @GetMapping("/hello") // a escrita na url fica /hello?name='Laura'&id=123
    public String sayHello2(@RequestParam String name, @RequestParam int id) {
        return "Hello " + name + " - " + id + "!";
    }

//    @PostMapping // indica metodo post - mandar pelo corpo da mensagem
//    public String getUser1(@RequestBody User user) {
//        return "User received: " + user.toString();
//    }

//    @PostMapping
//    public ResponseEntity<User> getUser2(@RequestBody User user) {
//        if (user.getId() == 23) {
//            return new ResponseEntity(user, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//    }

    // usando o DTO - chamar só o nome do user
    @PostMapping
    public ResponseEntity<UserDto> getUser3(@RequestBody User user) {
        if (user.getId() == 23) {
            UserDto userDto = new UserDto(user);
            return new ResponseEntity(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
