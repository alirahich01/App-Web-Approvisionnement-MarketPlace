package com.example.Backend.sec.entities;

import com.example.Backend.Models.Commande;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String username ;
    private String password ;
    private String adr_cli ;
    private String nom_cli ;
    private String pre_cli ;
    private String tel_cli ;
    private String ville_cli ;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<AppRole> roles =new ArrayList<>();
    @OneToMany(mappedBy = "client" , fetch=FetchType.LAZY)
    @JsonIgnore
    private Collection<Commande> commande;}


