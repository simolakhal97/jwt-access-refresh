package com.example.livreson.service;

import com.example.livreson.Model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
   Client saveClient (Client client );

    List<Client> AfficherClient();
    Client findClientByFullnameCl(String fullnameCl);
    public Optional<Client> findClientById(int id);

    void saveUser(Client userDto);

    Optional<Client> findUserByEmail(String email);

    List<Client> findAllUsers();
}
