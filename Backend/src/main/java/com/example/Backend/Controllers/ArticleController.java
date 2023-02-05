package com.example.Backend.Controllers;

import com.example.Backend.Models.Article;
import com.example.Backend.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @CrossOrigin(origins = "http://localhost:65183")
    @PostMapping("/ajtArticles")
    public Article addArticles(@RequestBody Article article){
        return articleService.SaveArticles(article);
    }

    @GetMapping("/Articles")
    public List<Article> Categories(){
        return articleService.getAllArticles();
    }

    @DeleteMapping("/suppArtic/{id}")
    public void DeleteArticles(@PathVariable int id){
        articleService.DeleteArticle(id);
    }

}
