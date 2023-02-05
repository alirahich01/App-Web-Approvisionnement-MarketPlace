package com.example.Backend.Controllers;

import com.example.Backend.Models.Article;
import com.example.Backend.Models.Commande;
import com.example.Backend.Models.LigneCmd;
import com.example.Backend.Repository.ArticleRepository;
import com.example.Backend.Repository.LignCmdRepository;
import com.example.Backend.Services.CommandeService;
import com.example.Backend.sec.entities.AppUser;
import com.example.Backend.sec.repo.AppUserRepository;
import com.example.Backend.sec.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController

public class CommandeController {
    @Autowired
    CommandeService commandeService;
    @Autowired
    AccountService accountService;

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    LignCmdRepository lignCmdRepository;
    @PostMapping("/ajtCommandes")
    public void addCommandes(@RequestBody Ligne_aide ligne_aide
    )
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser userResp = accountService.findUserByUsername( (String) auth.getPrincipal());
        Commande com=new Commande();
        com.setDate_cmd(LocalDateTime.now());
        /*AppUser client= appUserRepository.findById().get();*/
        com.setClient(userResp);
        com= commandeService.SaveCommandes(com);
        for(int i=0;i<ligne_aide.getId_articles().size();i++){
            LigneCmd ligne=new LigneCmd();
            ligne.setCommande(com);
            ligne.setQte_cmd(ligne_aide.getQtes().get(i));
            Article article=articleRepository.findById(ligne_aide.getId_articles().get(i)).get();
            ligne.setArticle(article);
            lignCmdRepository.save(ligne);
        }
    }
    @GetMapping("/Commandes")
    public List<Commande> Categories(){
        return commandeService.getAllCommandes();
    }
    @DeleteMapping("/suppComm/{id}")
    public void DeleteArticles(@PathVariable int id){
        commandeService.DeleteCommande(id);
    }
}