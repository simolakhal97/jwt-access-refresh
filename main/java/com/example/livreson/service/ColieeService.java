package com.example.livreson.service;

import com.example.livreson.Model.Coliee;

import java.util.List;
import java.util.Optional;

public interface ColieeService {
    Coliee saveColiee (Coliee coliee);
    List<Coliee> AfficherColiee();
    Coliee findUserByAddressDis(String addressDis);
    public Optional<Coliee> findColieeById(int id);

    Coliee    findColieeByValidate(String validate);
    Coliee    findColieeByNonvalidate(String nonvalidate);
    Coliee   findColieeByDansStock(String dansStock);

}
