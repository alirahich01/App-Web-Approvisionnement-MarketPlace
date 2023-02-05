package com.example.Backend.Repository;

import com.example.Backend.Models.LigneCmd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LignCmdRepository extends JpaRepository<LigneCmd,Integer> {

    public List<LigneCmd> findAll();}
