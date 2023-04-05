package com.example.livreson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.livreson.Model.Etudient;
import com.example.livreson.service.servicelmp.TestServicelmp;
import java.util.List;

@RestController
@RequestMapping
@Controller
public class TestController {
  @Autowired
  private TestServicelmp testServicelmp;

    @GetMapping("/etudient")
    public List<Etudient> getAllUsers(Authentication authentication) {
        return testServicelmp.AfficherEtudient();

    }

    @PreAuthorize("@userSecurity.hasEtudientId(authentication,#Id)")
    @GetMapping("/users/{etudientId}")
    public ResponseEntity<Etudient> getUserById(@PathVariable("etudientId") int Id, Authentication authentication) {
        System.out.println("Inside getuserbyid method");
        return ResponseEntity.ok().body(testServicelmp.findUserById(Id).get());

    }
    @PostMapping("/saveEtudient")
    public ResponseEntity<Etudient> saveusers(@RequestBody Etudient newEtudient, Authentication auth) {
        try {
            System.out.println(newEtudient.getNom()+"  "+auth.getName());
        }
        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body((testServicelmp.saveEtudient(newEtudient)));
    }


    @PutMapping("/users/{Id}")
    public ResponseEntity<Etudient> updateUser(@PathVariable("Id") int Id,@RequestBody Etudient newetudient) {
        return ResponseEntity.ok().body(testServicelmp.updateEtudient(Id,newetudient));

    }

    @DeleteMapping("/Etudient/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") int EtudientId) {
        testServicelmp.deleteEtudient(EtudientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    @GetMapping("/users/search")
    @PostAuthorize("returnObject.body.EtudientName==authenticated.Etudient")
    public ResponseEntity<Etudient> etudienDetails(Authentication authentication, @RequestParam("cname") String cName) throws Exception {
        System.out.println(authentication.getName().toString());
        Etudient etudient=testServicelmp.findUserBynom(cName);
        if(etudient==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudient not found");
        }
        return ResponseEntity.ok().body(etudient);

    }
}
