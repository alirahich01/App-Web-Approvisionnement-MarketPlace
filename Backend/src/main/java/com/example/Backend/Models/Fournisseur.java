package com.example.Backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nom_four")
    private String nom_four;
    @Column(name = "ville_four")
    private String ville_four ;
    @Column(name = "tel_four")
    private String tel_four ;


    @OneToMany(mappedBy="fournisseurs" , fetch=FetchType.LAZY)
    private Collection<Societe> societes;

    @OneToMany(mappedBy="fournisseurs" , fetch=FetchType.LAZY)
    private Collection<Livraison> livraisons;
}
