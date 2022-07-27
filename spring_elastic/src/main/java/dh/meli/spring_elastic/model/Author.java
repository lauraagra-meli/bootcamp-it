package dh.meli.spring_elastic.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Author {
    private int id; // é só um atributo, não faz diferenca pro elastic
    private String name;
}
