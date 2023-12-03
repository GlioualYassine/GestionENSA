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
@XmlRootElement
public class Etudiant {

    @Id
    @XmlElement
    private Long cne;

    @XmlElement
    private String nom;

    @XmlElement
    private String prenom;

    @XmlElement
    private String email;

    @XmlElement
    private String motDePasse;

    @XmlElement
    private Integer niveau;

    @XmlElement
    private String urlPhoto;
}
