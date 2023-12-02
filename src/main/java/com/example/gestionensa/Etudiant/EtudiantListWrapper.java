package com.example.gestionensa.Etudiant;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "etudiants")
@XmlAccessorType(XmlAccessType.FIELD)
public class EtudiantListWrapper {

    @XmlElement(name = "etudiant")
    private List<Etudiant> etudiant = new ArrayList<>();

    // Constructors, getters, and setters

    public EtudiantListWrapper() {
    }

    public EtudiantListWrapper(List<Etudiant> etudiants) {
        this.etudiant = etudiants;
    }

    public List<Etudiant> getEtudiants() {
        return etudiant;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiant = etudiants;
    }
}
