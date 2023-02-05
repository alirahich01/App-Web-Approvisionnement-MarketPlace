package com.example.Backend.Services;

import com.example.Backend.Models.Article;

import java.util.List;

public interface ArticleService {

    public void DeleteArticle(int id);
    public List<Article> getAllArticles();
    public Article SaveArticles(Article article);
}
