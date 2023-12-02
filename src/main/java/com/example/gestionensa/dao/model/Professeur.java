package com.example.gestionensa.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professeur {

    @Id
    private Integer cne;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
}
