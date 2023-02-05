package com.example.Backend.Services;

import com.example.Backend.Models.Panier;
import com.example.Backend.Repository.PanierRepository;
import com.example.Backend.sec.entities.AppUser;
import com.example.Backend.sec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class PanierServiceImpl implements PanierService{

    @Autowired
    PanierRepository panierRepository;
    @Autowired
    AccountService accountService;

    @Override
    public void DeleteArticle(int ArticId) {
        panierRepository.deleteById(ArticId);
    }

    @Override
    public List<Panier> getAllArticles() {
        return panierRepository.findAll();
    }

    @Override
    public List<Panier> getClientPanier(int id) {
        return panierRepository.getAllByClientId(id);
    }

    @Override
    public Panier SaveArticles(Panier panier) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser userResp = accountService.findUserByUsername( (String) auth.getPrincipal());
        panier.setClientId(userResp.getId());
        return panierRepository.save(panier);
    }
}