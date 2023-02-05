package com.example.Backend.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ligne_liv")
public class ligne_liv {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private int qte_liv;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="code_art", nullable=false)
    private Article article;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="num_liv", nullable=false)
    private Livraison livraison ;



}
