package com.dh.meli.spring02.handler;

import com.dh.meli.spring02.exception.NotFoundExDetails;
import com.dh.meli.spring02.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundExHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExDetails> handlerNotFoundEx(NotFoundException ex) {
        return new ResponseEntity<>(
                NotFoundExDetails.builder()
                        .title("Object not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        ); // dois parametros, 1 o que vai devolver, 2 qual o codigo http pra retormar
    }
}
