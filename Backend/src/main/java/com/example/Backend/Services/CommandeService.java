package com.example.Backend.Services;

import com.example.Backend.Models.Commande;

import java.util.List;

public interface CommandeService {

    public void DeleteCommande(int id);
    public List<Commande> getAllCommandes();
    public Commande SaveCommandes(Commande commande);
}
