package com.example.Backend.sec.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
public class RegistrationForm {
    private String username;
    private String password;
    private String repssword;
    private String adr_cli ;
    private String nom_cli ;
    private String pre_cli ;
    private String tel_cli ;
    private String ville_cli ;
}
