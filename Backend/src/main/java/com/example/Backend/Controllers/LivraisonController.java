package com.example.Backend.Controllers;

import com.example.Backend.Models.Livraison;
import com.example.Backend.Services.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivraisonController {

    @Autowired
    LivraisonService livraisonService;

    @GetMapping("/Livraison")
    public List<Livraison> Categories(){
        return livraisonService.getAllLivraison();
    }
}
