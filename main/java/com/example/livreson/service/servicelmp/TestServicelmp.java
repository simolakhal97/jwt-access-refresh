package com.example.livreson.service.servicelmp;


import com.example.livreson.Model.Etudient;
import com.example.livreson.repository.RepoTest;
import com.example.livreson.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class TestServicelmp implements TestService {
    @Autowired
    RepoTest repoTest;

    @Override
    public Etudient saveEtudient(Etudient etudient) {

       Etudient etudient1=repoTest.save(etudient);
        return etudient1;

    }
    @Override
    public List<Etudient> AfficherEtudient() {
      return (List<Etudient>) repoTest.findAll();
    }

    @Override
    public Etudient findUserBynom(String nom) {
        Etudient etudient=repoTest.findEtudientByNom(nom);
        return etudient;
    }
    public Optional<Etudient> findUserById(int id) {
        return repoTest.findById(id);
    }



    public Etudient updateEtudient(int Id,Etudient newetudient) {

        return repoTest.findById(Id)
                .map(employee -> {
                    employee.setNom(newetudient.getNom());
                    employee.setEmail(newetudient.getEmail());
                    employee.setPassword(newetudient.getPassword());
                    employee.setRoles(newetudient.getRoles());
                    return repoTest.save(employee);
                })
                .orElseGet(() -> {
                    newetudient.setId(Id);
                    return repoTest.save(newetudient);
                });
    }



    public Etudient deleteEtudient(int EtudientrId) {

        Optional<Etudient> removeEtudient=repoTest.findById(EtudientrId);
        if(removeEtudient==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        repoTest.deleteById(EtudientrId);
        return removeEtudient.get();

    }
    }