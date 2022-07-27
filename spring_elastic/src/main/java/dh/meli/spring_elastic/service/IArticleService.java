package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticleService {
    Article save(Article article);
    Article findById(int id);
    Article update(Article article);
    List<Article> findAll();
    String deleteById(int id);
    Page<Article> getPageByTitle(String title, Pageable pg);
}
