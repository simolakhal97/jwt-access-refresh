package com.example.livreson.repository;

import com.example.livreson.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienRepo extends JpaRepository<Client,Integer > {

    Optional<Client> findClientByEmailCl(String email);
     Client findClientByFullnameCl(String fullnameCl);




}
