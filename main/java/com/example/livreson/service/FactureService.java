package com.example.livreson.service;

import com.example.livreson.Model.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {
    Facture saveFacture (Facture facture);
    List<Facture> AfficherFacture();
Facture findFactureByCodefact(String Code_fact);
    public Optional<Facture> findFactureById(int id);

}
