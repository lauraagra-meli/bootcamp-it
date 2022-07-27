package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// O SUBJECT É O LADO N (MANY)

@Entity
@Getter @Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject") // ao pedir os dados do autor, ja pede o endereco
    @JsonIgnoreProperties("subject") // nao me traga de novo o assunto
    private List<Book> books;
}
