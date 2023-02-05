package com.example.Backend.Services;

import com.example.Backend.Models.LigneCmd;
import com.example.Backend.Repository.LignCmdRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LignCmdServiceImpl implements LignCmdService {

    @Autowired
    LignCmdRepository lignCmdRepository;

    @Override
    public LigneCmd SaveCmd(LigneCmd ligneCmd) {
        return lignCmdRepository.save(ligneCmd);
    }

    @Override
    public List<LigneCmd> getAllCmd() {

        return lignCmdRepository.findAll();
    }
}