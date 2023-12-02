package com.example.gestionensa.dao.model;

import com.example.gestionensa.Etudiant.Etudiant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtdNotes {

    @Id
    @ManyToOne
    @JoinColumn(name = "idSousMod")
    private SousModule sousModule;

    @Id
    @ManyToOne
    @JoinColumn(name = "cneEtd")
    private Etudiant etudiant;

    private Float note;
}
