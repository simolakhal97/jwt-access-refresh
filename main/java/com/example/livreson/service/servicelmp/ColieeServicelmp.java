package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Coliee;
import com.example.livreson.repository.ColieeRepo;
import com.example.livreson.service.ColieeService;
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
public class ColieeServicelmp implements ColieeService {
     @Autowired
    ColieeRepo colieeRepo;
      @Override
     public Coliee saveColiee(Coliee coliee) {
          Coliee newColiee=colieeRepo.save(coliee);
          return newColiee;
    }

    @Override
    public List<Coliee> AfficherColiee() {
        return colieeRepo.findAll();
    }
    public Coliee findUserByAddressDis(String addressDis) {
        Coliee coliee=colieeRepo.findColieeByAddressDis(addressDis);
        return coliee;
    }

    @Override
    public Optional<Coliee> findColieeById(int id) {
        return colieeRepo.findById(id);
    }

    @Override
    public Coliee findColieeByValidate(String validate) {
        Coliee coliee=colieeRepo.findColieeByAddressDis(validate);
        return coliee;
    }

    @Override
    public Coliee findColieeByNonvalidate(String nonvalidate) {
        Coliee coliee=colieeRepo.findColieeByAddressDis(nonvalidate);
        return coliee;
    }

    @Override
    public Coliee findColieeByDansStock(String dansStock) {
        Coliee coliee=colieeRepo.findColieeByAddressDis(dansStock);
        return coliee;
    }


    public Coliee updatefacture(int IdCOL, Coliee newcoliee) {

        return colieeRepo.findById(IdCOL)
                .map(coliee -> {
                    coliee.setPhoneCol(newcoliee.getPhoneCol());
                    coliee.setDistinatais(newcoliee.getDistinatais());
                    coliee.setAddressDis(newcoliee.getAddressDis());
                    coliee.setPrix(newcoliee.getPrix());
                    coliee.setNote(newcoliee.getNote());
                    coliee.setProdact(newcoliee.getProdact());

                    return colieeRepo.save(coliee);
                })
                .orElseGet(() -> {
                    newcoliee.setIdCOL(IdCOL);
                    return colieeRepo.save(newcoliee);
                });
    }
    public Coliee updatefactureinemployaa(int IdCOL, Coliee newcoliee) {

        return colieeRepo.findById(IdCOL)
                .map(coliee -> {
                    coliee.setPhoneCol(newcoliee.getPhoneCol());
                    coliee.setDistinatais(newcoliee.getDistinatais());
                    coliee.setAddressDis(newcoliee.getAddressDis());
                    coliee.setPrix(newcoliee.getPrix());
                    coliee.setNote(newcoliee.getNote());
                    coliee.setProdact(newcoliee.getProdact());
                    coliee.setValidate(newcoliee.getValidate());
                    coliee.setNonvalidate(newcoliee.getNonvalidate());
                    coliee.setDansStock(newcoliee.getDansStock());

                    return colieeRepo.save(coliee);
                })
                .orElseGet(() -> {
                    newcoliee.setIdCOL(IdCOL);
                    return colieeRepo.save(newcoliee);
                });
    }
    public Coliee deleteColiee(int colieeId) {

        Optional<Coliee> removecolieeId=colieeRepo.findById(colieeId);
        if(removecolieeId==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        colieeRepo.deleteById(colieeId);
        return removecolieeId.get();

    }
}
