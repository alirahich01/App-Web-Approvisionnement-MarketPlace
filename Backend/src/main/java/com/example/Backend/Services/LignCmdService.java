package com.example.Backend.Services;



import com.example.Backend.Models.LigneCmd;

import java.util.List;

public interface LignCmdService {

    public LigneCmd SaveCmd (LigneCmd ligneCmd);
    public List<LigneCmd> getAllCmd();
}
