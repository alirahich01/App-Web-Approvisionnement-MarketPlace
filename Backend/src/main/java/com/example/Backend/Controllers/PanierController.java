package com.example.Backend.Controllers;

import com.example.Backend.Models.Article;
import com.example.Backend.Models.Panier;
import com.example.Backend.Repository.ArticleRepository;
import com.example.Backend.Services.ArticleService;
import com.example.Backend.Services.PanierService;
import com.example.Backend.sec.entities.AppRole;
import com.example.Backend.sec.entities.AppUser;
import com.example.Backend.sec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class PanierController {

    @Autowired
    PanierService panierService;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AccountService accountService;
    @PostMapping("/addarticleToPanier")
    public Panier addArticles(@RequestBody Panier panier){
        return panierService.SaveArticles(panier);
    }


    @GetMapping("/ArticlesPanier")
    public List<Article> Categories(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser userResp = accountService.findUserByUsername( (String) auth.getPrincipal());
        Long  cli_id=userResp.getId();
        List<Panier> pp=panierService.getAllArticles();
        List<Article> articles=new ArrayList<>();
        for(int i=0;i<pp.size();i++){
            if(pp.get(i).getClientId()==cli_id) {
                int id_art=pp.get(i).getArticId();
                Article art= articleRepository.findById(id_art).get();
                articles.add(art);
            }
        }
        return articles;
    }

    @GetMapping("/qtes")
    public List<Integer> getQts(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser userResp = accountService.findUserByUsername( (String) auth.getPrincipal());
        Long  cli_id=userResp.getId();
        List<Panier> pp=panierService.getAllArticles();
        List<Integer> qtes = new ArrayList<>();
        for(int i=0;i<pp.size();i++){
            if(pp.get(i).getClientId()==cli_id) {
                int qte=pp.get(i).getQtcmd();
                qtes.add(qte);
            }
        }
        return qtes;

    }

    @GetMapping("/getRole")
    public Collection<AppRole> getRole(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser userResp = accountService.findUserByUsername( (String) auth.getPrincipal());
        return userResp.getRoles();
    }
    @DeleteMapping("/deletarticle/{ArticId}")
    public void DeleteArticles(@PathVariable int ArticId){
        panierService.DeleteArticle(ArticId);
    }
    @GetMapping("/ClientPanier/{id}")
    public List<Panier> getClientPanier(@PathVariable int id){
        return panierService.getClientPanier(id);
    }
}