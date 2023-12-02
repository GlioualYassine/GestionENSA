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
public class Niveau {

    @Id
    private Integer idNv;
    private String nomNiveau;
    private Integer capacite;
}
