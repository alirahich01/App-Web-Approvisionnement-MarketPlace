package com.example.Backend.Services;


import com.example.Backend.Models.Panier;

import java.util.List;

public interface PanierService {

    public void DeleteArticle(int ArticId);
    public List<Panier> getAllArticles();
    public List<Panier> getClientPanier(int id);
    public Panier SaveArticles(Panier panier);
}
