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
public class Module {

    @Id
    private Integer idMod;
    private String intitule;
    private Integer mh;
}
