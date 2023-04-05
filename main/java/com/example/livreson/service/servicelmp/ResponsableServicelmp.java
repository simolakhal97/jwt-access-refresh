package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Responsable;
import com.example.livreson.repository.ResponsableRepo;
import com.example.livreson.service.ResponsableService;
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
public class ResponsableServicelmp implements ResponsableService {

    @Autowired
    ResponsableRepo responsableRepo;

    @Override
    public Responsable saveResponsable(Responsable responsable) {
        Responsable responsable1=responsableRepo.save(responsable);
        return responsable1;
    }

    @Override
    public List<Responsable> AfficherResponsable() {
        return (List<Responsable>) responsableRepo.findAll();
    }

    @Override
    public Responsable findResponsableByFullnameRes(String fullnameRes) {
        Responsable responsable=responsableRepo.findResponsableByFullnameRes(fullnameRes);
        return responsable;
    }

    @Override
    public Optional<Responsable> findResponsableById(int id) {
        return responsableRepo.findById(id);
    }

    public Responsable updateResponsable(int IdRES, Responsable newResponsable) {

        return responsableRepo.findById(IdRES)
                .map(responsable -> {
                    responsable.setFullnameRes(newResponsable.getFullnameRes());
                    responsable.setEmailRes(newResponsable.getEmailRes());
                    responsable.setPasswordRes(newResponsable.getPasswordRes());
                    responsable.setRevenu(newResponsable.getRevenu());
                    responsable.setRoles(newResponsable.getRoles());
                    return responsableRepo.save(responsable);
                })
                .orElseGet(() -> {
                    newResponsable.setIdRES(IdRES);
                    return responsableRepo.save(newResponsable);
                });
    }



    public Responsable deleteEtudient(int ResponsableId) {

        Optional<Responsable> removeResponsable=responsableRepo.findById(ResponsableId);
        if(removeResponsable==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        responsableRepo.deleteById(ResponsableId);
        return removeResponsable.get();

    }
}
