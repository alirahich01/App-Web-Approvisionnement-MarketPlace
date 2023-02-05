package com.example.Backend.Models;

import com.example.Backend.sec.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Long clientId;
    private int articId;
    private int qtcmd;


}
