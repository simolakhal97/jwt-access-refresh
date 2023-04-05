package com.example.livreson.controller;

import  com.example.livreson.Model.Client;
import com.example.livreson.Model.Employee;
import com.example.livreson.service.servicelmp.ClientServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping
@Controller
public class ClientController {

    @Autowired
    private ClientServicelmp clientServicelmp;
    @GetMapping("/getClient")
    public List<Client> getAllClient(Authentication authentication) {
        return clientServicelmp.AfficherClient();

    }

    @PreAuthorize("@userSecurity.hasclienRepoId(authentication,#Id)")
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("colieeId") int Id, Authentication authentication) {
        System.out.println("Inside clientside method");
        return ResponseEntity.ok().body(clientServicelmp.findClientById(Id).get());
    }
    /*
    @PostMapping("/saveclient")
    public ResponseEntity<Client> saveusers(@RequestBody Client newClient, Authentication auth) {
        try {
            System.out.println(newClient.getFullnameCl()+"  "+auth.getName());
        }

        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((clientServicelmp.saveClient(newClient)));
    }*/
    @PutMapping("/Client/{Id}")
    public ResponseEntity<Integer> updateUser(@PathVariable("Id") int Id, @RequestBody Client newClient) {
        return ResponseEntity.ok().body(clientServicelmp.updateClient(Id,newClient).getIdClient( ));
    }

    @DeleteMapping("/client/{clientId}")
    public ResponseEntity<Object> deleteClient(@PathVariable("clientId") int clientId) {
        clientServicelmp.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @DeleteMapping("/clientDeleteAll")
    public String deleteAllPassingEntities(@RequestBody List<Client> client) {
        clientServicelmp.deleteAllClient(client);
        return "Successfully deleted all enitities which has been passed as request data";
    }

/*
    @GetMapping("/Client/search")
    public ResponseEntity<Client> ClientDetails(Authentication authentication, @RequestParam("cname") String cmail) throws Exception {
        System.out.println(authentication.getName().toString());
        boolean client=clientServicelmp.findClientByemailCl(cmail);
        if(client==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudient not found");
        }
        return ResponseEntity.ok().body(client);

    }*/
}
