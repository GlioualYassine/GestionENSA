package com.example.gestionensa.dao.model;

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
public class SousModule {

    @Id
    private Integer idSousMod;
    private String intitule;
    private Integer mh;

    @ManyToOne
    @JoinColumn(name = "idProf")
    private Professeur professeur;

    @ManyToOne
    @JoinColumn(name = "idMod")
    private Module module;
}
