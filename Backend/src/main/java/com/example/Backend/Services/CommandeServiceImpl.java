package com.example.Backend.Services;

import com.example.Backend.Models.Commande;
import com.example.Backend.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public void DeleteCommande(int id) {
        commandeRepository.deleteById(id);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande SaveCommandes(Commande commande) {
        return commandeRepository.save(commande);
    }
}
