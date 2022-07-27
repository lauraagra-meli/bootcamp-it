package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity // classe deve ser armazenada no banco de dados
@Getter @Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // nome do campo na tabela Adress que referencia a tabela Author // ao pedir os dados do autor, ja pede o endereco // cascade - salvar relacionamentos entre tabelas
    @JsonIgnoreProperties("author") // pra não acontecer erro de stack overflow, pois o autor vai precisar do endereco e endereco precisa do autor, entrando num loop
    private Address address;

    @ManyToMany
    @JoinTable(name = "book_author", // nome da tabela de ligacao
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"), // atributo do autor na tabela de ligacao
            inverseJoinColumns = @JoinColumn(name = "bood_id", referencedColumnName = "id") // atributod dp livro na tabela de ligacao
    )
    @JsonIgnoreProperties("books")
    private List<Book> books;
}
