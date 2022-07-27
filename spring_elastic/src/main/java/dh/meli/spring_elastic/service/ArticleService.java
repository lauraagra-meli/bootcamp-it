package dh.meli.spring_elastic.service;

import dh.meli.spring_elastic.model.Article;
import dh.meli.spring_elastic.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepo repo; // injecao de dependencia por atributo

    @Override
    public Article save(Article article) {
        return repo.save(article);
    }

    @Override
    public Article findById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public Article update(Article article) {
        return repo.save(article);
    }

    @Override
    public List<Article> findAll() {
        // como nao ta tranformando um iterable num list, fazemos isso na mao, adicionando cada item do iterable a uma lista
//        List<Article> list = new ArrayList<>();
//        Iterable<Article> resp = repo.findAll();
//        resp.forEach(list::add); // adicionando cada item
//        return list;
        return repo.findAllArticles();
    }

    @Override
    public String deleteById(int id) {
        repo.deleteById(id);
        return "Artigo removido com sucesso.";
    }

    @Override
    public Page<Article> getPageByTitle(String title, Pageable pg) {
        return repo.findByTitle(title, pg);
    }
}
