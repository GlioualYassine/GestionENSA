package com.example.gestionensa.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {

    @ManyToOne
    @JoinColumn(name = "idSousMod")
    private SousModule sousModule;

    @ManyToOne
    @JoinColumn(name = "idProf")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "idSalle")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "idNiveau")
    private Niveau niveau;

    private String jour;
    private Time heureDebut;
    private Time heureFin;
}
