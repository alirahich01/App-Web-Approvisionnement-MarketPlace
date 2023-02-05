package com.example.Backend.Controllers;

import java.util.List;

public class Ligne_aide {
    private List<Integer> id_articles;
    private List<Integer> qtes;

    public List<Integer> getId_articles() {
        return id_articles;
    }

    public void setId_articles(List<Integer> id_articles) {
        this.id_articles = id_articles;
    }

    public List<Integer> getQtes() {
        return qtes;
    }

    public void setQtes(List<Integer> qtes) {
        this.qtes = qtes;
    }
}
