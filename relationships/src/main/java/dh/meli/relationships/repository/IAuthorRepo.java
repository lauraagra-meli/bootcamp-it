package dh.meli.relationships.repository;

import dh.meli.relationships.dto.AuthorDTO;
import dh.meli.relationships.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends CrudRepository<Author, Long> {
    // usando JPQL
    @Query("select a from Author a where a.id = ?1") // pra fazer uma query igual a do banco - o ?1 é o numero de parametros passados a abaixo
    AuthorDTO getById(long id);

    // usando consulta nativa - direto pro banco de dados
    @Query(value = "select * from author where id = ?1", nativeQuery = true) // consulta nativa, nao é mais JPA
    Author getNativeById(long id);

    // executar de imediato
    @Query("select a from Author a left join fetch a.address where a.id = :id") // :id significa o parametro recebido no metodo
    AuthorDTO getDtoEagle(long id);
}
