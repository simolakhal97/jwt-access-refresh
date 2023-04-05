package com.example.livreson.controller;

import com.example.livreson.Model.Client;
import com.example.livreson.service.servicelmp.ClientServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping
public class SignupController {
    @Autowired
    ClientServicelmp clientServicelmp;
    @PostMapping("/client-register")
    public String signupView() {
        return "redirect:/client-login";
    }
    @PostMapping("saveclient")
    public ResponseEntity<Client> saveusers(@RequestBody Client newClient, Authentication auth) {
        try {
            System.out.println(newClient.getFullnameCl()+"  "+auth.getName());
            }

        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((clientServicelmp.saveClient(newClient)));
    }
}
