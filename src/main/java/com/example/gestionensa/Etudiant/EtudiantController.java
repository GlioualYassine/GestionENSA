package com.example.gestionensa.Etudiant;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.io.StringWriter;
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
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.findAllEtudiants();
        return ResponseEntity.ok().body(etudiants);
    }
*/@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
   public ResponseEntity<byte[]> downloadEtudiantsXml() {
       List<Etudiant> etudiants = etudiantService.findAllEtudiants();
       String xmlContent = convertEtudiantsToXml(etudiants);

       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       headers.setContentDispositionFormData("attachment", "etudiants.xml");

       return ResponseEntity.ok()
               .headers(headers)
               .body(xmlContent.getBytes());
   }

    // Méthode pour convertir la liste d'étudiants en XML à l'aide de JAXB
    private String convertEtudiantsToXml(List<Etudiant> etudiants) {
        try {
            // Initialiser le contexte JAXB avec la classe racine (ici, List<Etudiant>)
            JAXBContext context = JAXBContext.newInstance(List.class, Etudiant.class);

            // Créer le marshaller
            Marshaller marshaller = context.createMarshaller();

            // Convertir la liste d'étudiants en XML
            // Convertir l'objet Java en XML (ici, un StringWriter est utilisé pour stocker le résultat)
            StringWriter writer = new StringWriter();
            marshaller.marshal(etudiants, writer);

            return writer.toString();
        } catch (JAXBException e) {
            // Gérer les exceptions JAXB
            e.printStackTrace();
            return ""; // ou autre comportement en cas d'erreur
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