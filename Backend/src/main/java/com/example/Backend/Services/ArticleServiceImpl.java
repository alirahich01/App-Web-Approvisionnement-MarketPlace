package com.example.Backend.Services;


import com.example.Backend.Models.Article;
import com.example.Backend.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public void DeleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article SaveArticles(Article article) {
        return articleRepository.save(article);
    }


}
