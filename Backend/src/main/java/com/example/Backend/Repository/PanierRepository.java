package com.example.Backend.Repository;


import com.example.Backend.Models.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier,Integer> {

    public List<Panier> findAll();
    public void deleteById(int ArticId);
    public  List<Panier> getAllByClientId(int id);
    public Panier findAllById(int id);
}
