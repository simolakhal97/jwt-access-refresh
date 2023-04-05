package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Client;
import com.example.livreson.Model.Role;
import com.example.livreson.repository.ClienRepo;
import com.example.livreson.repository.ColieeRepo;
import com.example.livreson.repository.RoleRepos;
import com.example.livreson.service.ClientService;
import com.sun.xml.messaging.saaj.util.Base64;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class ClientServicelmp implements ClientService {

    @Autowired
    RoleRepos roleRepos;
    @Autowired
    ClienRepo clienRepo;

    @Autowired
    ColieeRepo colieeRepo;
    @Override
    public Client saveClient(Client client) {
         return clienRepo.save(client) ;
    }
    @Override
    public List<Client> AfficherClient() {
        return clienRepo.findAll();
    }
    @Override
    public Client findClientByFullnameCl(String fullnameCl) {
        Client client=clienRepo.findClientByFullnameCl(fullnameCl);
        return client;
    }
    public Optional<Optional<Client>> findClientByemailCl(String emailCl) {

        return Optional.ofNullable(clienRepo.findClientByEmailCl(emailCl));
    }
    @Override
    public Optional<Client> findClientById(int id) {
        return clienRepo.findById(id);
    }

    public Client updateClient(int IdClient, Client newClient) {

        return  clienRepo.findById(IdClient)
                .map(client -> {
                    client.setFullnameCl(newClient.getFullnameCl());
                    client.setEmailCl(newClient.getEmailCl());
                    client.setrIB(newClient.getrIB());
                    client.setPasswordClient(newClient.getPasswordClient());
                    client.setBanckName(newClient.getBanckName());
                    client.setStoreName(newClient.getStoreName());
                    client.setVillecl(newClient.getVillecl());
                    client.setPhone(newClient.getPhone());
                    client.setRoles(newClient.getRoles());
                    return clienRepo.save(client);
                })
                .orElseGet(() -> {
                    newClient.getIdClient(IdClient);
                    return clienRepo.save(newClient);
                });
    }

    public Client deleteClient(int clientId) {
        Optional<Client> removeClient=clienRepo.findById(clientId);
        if(removeClient==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        clienRepo.deleteById(clientId);
        return removeClient.get();
    }
    public void deleteAllClient(List<Client> client) {
        clienRepo.deleteAll(client);
    }


















    @Override
    public void saveUser(Client userDto) {
        Client user = new Client();
        user.setEmailCl(userDto.getEmailCl());
        // encrypt the password using spring security

        user.setPasswordClient(Arrays.toString(Base64.encode(userDto.getPasswordClient().getBytes( ))));

        Role role = roleRepos.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        clienRepo.save(user);
    }

    @Override
    public Optional<Client> findUserByEmail(String email) {
        return clienRepo.findClientByEmailCl(email);
    }

    @Override
    public List<Client> findAllUsers() {
       return  clienRepo.findAll();

    }



    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepos.save(role);
    }

}
