package com.example.livreson.controller;

import com.example.livreson.Model.Facture;
import com.example.livreson.service.servicelmp.FactureServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping
public class FactureController {


    @Autowired
   private FactureServicelmp factureServicelmp;

    @GetMapping("/getfacture")
    public List<Facture> getAllFacture(Authentication authentication) {
        return factureServicelmp.AfficherFacture();

    }

    @PreAuthorize("@userSecurity.hasfactureRepoId(authentication,#Id)")
    @GetMapping("/facture/{factureId}")
    public ResponseEntity<Facture> getfactureById(@PathVariable("factureId") int Id, Authentication authentication) {
        System.out.println("Inside facture side method");
        return ResponseEntity.ok().body(factureServicelmp.findFactureById(Id).get());
    }
    @PostMapping("/saveFacture")
    public ResponseEntity<Facture> savefacture(@RequestBody Facture newFacture, Authentication auth) {
        try {
            System.out.println(newFacture.getNoteFact()+"  "+auth.getName());
        }

        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((factureServicelmp.saveFacture(newFacture)));
    }
    @PutMapping("/facture/{Id}")
    public ResponseEntity<Facture> updatefacture(@PathVariable("Id") int Id,@RequestBody Facture newFacture) {
        return ResponseEntity.ok().body(factureServicelmp.updatefacture(Id,newFacture));
    }

    @DeleteMapping("/facture/{factureId}")
    public ResponseEntity<Object> deletefacture(@PathVariable("factureId") int FactureId) {
        factureServicelmp.deleteFacture(FactureId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }





}
