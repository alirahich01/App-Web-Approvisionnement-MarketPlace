package com.example.Backend.Repository;

import com.example.Backend.Models.Fournisseur;
import com.example.Backend.Models.Livraison;
import com.example.Backend.Models.Societe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {

   

}
