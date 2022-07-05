package com.dh.meli.spring02.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data // resume os getter, setter, constructor, toString...
@Builder // padrao para criar objetos sem utilizar o constructor
public class NotFoundExDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;


}
