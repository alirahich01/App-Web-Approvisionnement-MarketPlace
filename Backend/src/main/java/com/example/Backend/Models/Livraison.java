package com.example.Backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livraison")

public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date_liv;

    @OneToMany(mappedBy = "livraison" , fetch=FetchType.LAZY)
    private Collection<ligne_liv> ligneLivs;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="code_four", nullable=false)
    private Fournisseur fournisseurs;

    @ManyToMany
    @JoinTable(
            name = "ligne_liv",
            joinColumns = @JoinColumn(name = "num_liv"),
            inverseJoinColumns = @JoinColumn(name = "code_art"))
    Set<Article> likdarticles;
}
