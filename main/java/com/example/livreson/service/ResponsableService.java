package com.example.livreson.service;

import com.example.livreson.Model.Responsable;

import java.util.List;
import java.util.Optional;

public interface ResponsableService {
    Responsable saveResponsable (Responsable responsable);
    List<Responsable> AfficherResponsable();
    Responsable findResponsableByFullnameRes(String fullnameRes);
    public Optional<Responsable> findResponsableById(int id);

}
