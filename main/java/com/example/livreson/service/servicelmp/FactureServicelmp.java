package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Facture;
import com.example.livreson.repository.FactureRepo;
import com.example.livreson.service.FactureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Component
@RequiredArgsConstructor
@Service
public class FactureServicelmp implements FactureService {
   @Autowired
    FactureRepo factureRepo;
    @Override
    public Facture saveFacture(Facture facture) {
        Facture facture1=factureRepo.save(facture);
        return facture1;
    }

    @Override
    public List<Facture> AfficherFacture() {
        return  (List<Facture>)factureRepo.findAll();
    }

    @Override
    public Facture findFactureByCodefact(String Codefact) {
        Facture facture=factureRepo.findFactureByCodefact(Codefact);
        return facture;
    }



    @Override
    public Optional<Facture> findFactureById(int id) {
        return factureRepo.findById(id);
    }
    public Facture updatefacture(int Id_fact, Facture newfacture) {

        return factureRepo.findById(Id_fact)
                .map(facture -> {
                    facture.setCodefact(newfacture.getCodefact());
                    facture.setNbColis(newfacture.getNbColis());
                    facture.setMontent(newfacture.getMontent());
                    facture.setNoteFact(newfacture.getNoteFact());
                    facture.setDateCreationFact(newfacture.getDateCreationFact());
                    facture.setDateVercementFact(newfacture.getDateVercementFact());
                    facture.setVerserG(newfacture.getVerserG());

                    return factureRepo.save(facture);
                })
                .orElseGet(() -> {
                    newfacture.setIdfact(Id_fact);
                    return factureRepo.save(newfacture);
                });
    }



    public Facture deleteFacture(int factureId) {

        Optional<Facture> removeFacture=factureRepo.findById(factureId);
        if(removeFacture==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        factureRepo.deleteById(factureId);
        return removeFacture.get();

    }
}
