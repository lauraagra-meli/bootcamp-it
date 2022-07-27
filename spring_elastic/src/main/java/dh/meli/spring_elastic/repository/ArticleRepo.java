package dh.meli.spring_elastic.repository;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> { // trabalhar com paginacao e ordenacao e tambem extende o CRUD
    @Query("{\"match_all\": {}") // caracter de scape \" pra nao confundir as aspas - traga tudo
    List<Article> findAllArticles();

    // traz a resposta paginada - por etapas
    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    Page<Article> findByTitle(String title, Pageable pg);
}
