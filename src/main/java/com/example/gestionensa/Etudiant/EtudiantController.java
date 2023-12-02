package com.example.gestionensa.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

   /* @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.findAllEtudiants();
    }*/

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Etudiant>> getAllEtudiantsXml() {
        List<Etudiant> etudiants = etudiantService.findAllEtudiants();

        if (!etudiants.isEmpty()) {
            EtudiantListWrapper wrapper = new EtudiantListWrapper(etudiants);
            return ResponseEntity.ok(wrapper.getEtudiants());
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/{cne}")
    public ResponseEntity<Etudiant> getEtudiantByCne(@PathVariable long cne) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantByCne(cne);
        return etudiant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant savedEtudiant = etudiantService.save(etudiant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEtudiant);
    }

    @PutMapping
    public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant) {
        if (etudiantService.getEtudiantByCne(etudiant.getCne()).isPresent()) {
            Etudiant updatedEtudiant = etudiantService.update(etudiant);
            return ResponseEntity.ok(updatedEtudiant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cne}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable long cne) {
        etudiantService.delete(cne);
        return ResponseEntity.noContent().build();
    }
}