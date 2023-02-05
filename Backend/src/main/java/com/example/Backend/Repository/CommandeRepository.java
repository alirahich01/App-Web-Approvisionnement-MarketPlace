package com.example.Backend.Repository;

import com.example.Backend.Models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {

}
