package com.ism.services.implement;

import java.util.List;
import java.util.Objects;

import com.ism.data.entities.Article;
import com.ism.data.repository.IArticleRepository;
import com.ism.services.IArticleService;

public class ArticleService implements IArticleService {
    private IArticleRepository articleRepository;

    public ArticleService(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article add(Article value) {
        return articleRepository.insert(value); 
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.selectAll();
    }

    @Override
    public List<Article> findAllAvailable() {
        return articleRepository.selectAllAvailable();
    }

    @Override
    public int length() {
        return articleRepository.size();
    }

    @Override
    public Article findBy(Article article, List<Article> articles) {
        for (Article value : articles) {
            if (Objects.equals(value.getId(), article.getId())) {
                return value;
            }
            if (article.getLibelle() != null && value.getLibelle().compareTo(article.getLibelle()) == 0) {
                return value;
            }
        }
        return null;
    }
    

    @Override
    public void update(Article article) {
        articleRepository.update(article);
    }
}