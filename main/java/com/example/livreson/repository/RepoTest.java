package com.example.livreson.repository;

import com.example.livreson.Model.Etudient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepoTest extends CrudRepository<Etudient, Integer> {
       Etudient findEtudientByNom(String nom);

}
