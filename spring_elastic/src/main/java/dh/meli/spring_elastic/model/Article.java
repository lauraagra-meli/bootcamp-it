package dh.meli.spring_elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "meli_doc") // armazenar no banco de dados noSQL - indice: nome do banco de dados
@Getter @Setter
public class Article {
    @Id
    private int id;

    @Field(name = "title", type = FieldType.Text) // informacoes referente ao titulo
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true) // persistir junto no momento da criacao - nested: aninhado - includeInParent: gravar junto com o artigo
    private List<Author> authors; // relacionamento
}
