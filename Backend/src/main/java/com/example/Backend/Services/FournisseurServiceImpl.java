package com.example.Backend.Services;

import com.example.Backend.Models.Fournisseur;
import com.example.Backend.Models.Livraison;
import com.example.Backend.Models.Societe;
import com.example.Backend.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService{

    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur getAll(int id) {
        return fournisseurRepository.findById(id).get();
    }


   /* @Override
    public List<Livraison> getAllLivraisons() {
        return fournisseurRepository.findAllByLivraisons();
    }

    @Override
    public List<Societe> getAllSocietes() {
        return fournisseurRepository.findAllBySocietes();
    }*/

}
