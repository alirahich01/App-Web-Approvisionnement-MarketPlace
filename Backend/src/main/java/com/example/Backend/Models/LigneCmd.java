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
@Table(name = "ligne_cmd")
public class LigneCmd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    private int qte_cmd;


    @ManyToOne
    @JoinColumn(name="code_art", nullable=false)
    private Article article;

    @ManyToOne
    @JoinColumn(name="num_cmd", nullable=false)
    @JsonIgnore
    private Commande commande ;


}
