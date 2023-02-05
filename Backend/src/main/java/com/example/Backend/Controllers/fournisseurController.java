package com.example.Backend.Controllers;

import com.example.Backend.Models.Fournisseur;
import com.example.Backend.Services.FournisseurService;
import com.example.Backend.Services.FournisseurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fournisseurController {

    @Autowired
    FournisseurService fournisseurService;
    @GetMapping("/Fournisseur/{id}")
    public Fournisseur getAll(@PathVariable int id) {
        return fournisseurService.getAll(id);
    }
}
