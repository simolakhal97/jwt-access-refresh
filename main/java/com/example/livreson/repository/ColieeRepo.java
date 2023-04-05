package com.example.livreson.repository;

import com.example.livreson.Model.Coliee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColieeRepo extends JpaRepository<Coliee,Integer > {
    Coliee findColieeByAddressDis(String addressDis);
    Coliee findColieeByValidate(int validate);
    Coliee findColieeByNonvalidate(int nonvalidate);
    Coliee findColieeByDansStock(int dansStock);
    Coliee findByIdCOL( int id);
}
