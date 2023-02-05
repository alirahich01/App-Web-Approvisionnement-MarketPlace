package com.example.Backend.Repository;

import com.example.Backend.Models.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {

    public List<Livraison> findAll();
}
