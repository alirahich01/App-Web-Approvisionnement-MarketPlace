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
@Table(name = "societe")
public class Societe {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_soc;
    @Column(name = "nom_ste")
    private String nom_ste;
    @Column(name = "tel_ste")
    private String tel_ste;
    @Column(name = "fax_ste")
    private String fax_ste;
    @Column(name = "ville_ste")
    private String ville_ste;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="code_four", nullable=false)
    private Fournisseur fournisseurs;

}
