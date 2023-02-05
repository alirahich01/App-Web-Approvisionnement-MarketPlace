package com.example.Backend.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nom_art")
    private String nom_art;
    @Column(name = "pu_art")
    private Float pu_art;
    @Column(name = "qte_stock")
    private Float qte_stock;

    @OneToMany(mappedBy = "article" , fetch=FetchType.LAZY)
    @JsonIgnore
    private Collection<LigneCmd> ligneCmds;

    @OneToMany(mappedBy = "article" , fetch=FetchType.LAZY)
    private Collection<ligne_liv> ligneLivs;
    @JsonIgnore
    @ManyToMany(mappedBy = "likdarticles")
    Set<Livraison> livraison;
}
