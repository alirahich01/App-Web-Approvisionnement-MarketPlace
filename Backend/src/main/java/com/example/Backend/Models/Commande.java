package com.example.Backend.Models;
import com.example.Backend.sec.entities.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "date_cmd")
    private LocalDateTime date_cmd;

    //@ManyToOne
    //@JoinColumn(name="code_cli", nullable=false)
   //private Client client;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="code_cli", nullable=false)
    private AppUser client;
    @OneToMany(mappedBy = "commande" , fetch=FetchType.LAZY)
    private Collection<LigneCmd> ligneCmds;


}
