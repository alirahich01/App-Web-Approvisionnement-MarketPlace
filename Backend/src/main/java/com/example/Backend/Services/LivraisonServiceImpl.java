package com.example.Backend.Services;

import com.example.Backend.Models.Livraison;
import com.example.Backend.Repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivraisonServiceImpl implements LivraisonService{

    @Autowired
    LivraisonRepository livraisonRepository;

    @Override
    public List<Livraison> getAllLivraison() {
        return livraisonRepository.findAll();
    }
}
