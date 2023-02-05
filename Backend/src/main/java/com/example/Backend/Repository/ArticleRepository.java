package com.example.Backend.Repository;

import com.example.Backend.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

    public void deleteById(int id);

}
