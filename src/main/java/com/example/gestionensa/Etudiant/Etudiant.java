package com.example.gestionensa.Etudiant;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.xml.bind.annotation.XmlRootElement;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {


    @Id
    private Long cne;

    private String nom;

    private String prenom;

    private String email;

    private String motDePasse;

    private Integer niveau;

    private String urlPhoto;
}
