package dh.meli.relationships.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// carnalidades

@Entity
@Getter @Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne // relacionamento entre tabelas UM PRA UM
    @JoinColumn(name = "id_author") // nome da chave primaria da tabela author, indica que sera a chave entrangeira
    private Author author;
}
