package com.example.gestionensa.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;
    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    // Méthode pour récupérer tous les étudiant
    List<Etudiant> findAllEtudiants(){
        return etudiantRepository.findAll();
    }

    // Méthode pour récupérer un étudiant par son cne
    public Optional<Etudiant> getEtudiantByCne(long cne) {
        return etudiantRepository.findById(cne);
    }

    Etudiant save(Etudiant e){
        return etudiantRepository.save(e);
    }

    Etudiant findByEmail(String email){
          return etudiantRepository.findByEmail(email);
    }
    Etudiant update(Etudiant e){
        return etudiantRepository.save(e);
    }
    void deleteByEmail (String email){
        etudiantRepository.deleteByEmail(email);
    }
    void delete(long cne) {
        Optional<Etudiant> etudiant = getEtudiantByCne(cne);

        etudiant.ifPresent(etudiantRepository::delete);
    }


}
