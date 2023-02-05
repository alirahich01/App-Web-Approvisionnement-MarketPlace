package com.example.Backend.Services;

import com.example.Backend.Models.Fournisseur;
import com.example.Backend.Models.Livraison;
import com.example.Backend.Models.Societe;
import org.springframework.stereotype.Service;

import java.util.List;
public interface FournisseurService {

    /*public List<Livraison> getAllLivraisons();
    public List<Societe> getAllSocietes();*/
    public Fournisseur getAll(int id);
}
