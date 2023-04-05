package com.example.livreson.repository;

import com.example.livreson.Model.Responsable;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepo extends JpaRepository<Responsable,Integer > {
    Responsable findResponsableByFullnameRes(String fullnameRes);
Responsable findResponsableByEmailRes(String emailRes);

}
