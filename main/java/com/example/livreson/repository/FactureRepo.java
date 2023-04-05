package com.example.livreson.repository;

import com.example.livreson.Model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepo extends JpaRepository<Facture,Integer> {
         Facture findFactureByCodefact(String codefact);
}
