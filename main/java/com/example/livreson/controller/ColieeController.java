package com.example.livreson.controller;

import com.example.livreson.Model.Coliee;
import com.example.livreson.service.servicelmp.ColieeServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ColieeController {
      @Autowired
   private  ColieeServicelmp colieeServicelmp;

    @GetMapping("/getColiee")
    public List<Coliee> getAllColiee(Authentication authentication) {
        return colieeServicelmp.AfficherColiee();

    }


    @PreAuthorize("@userSecurity.hascolieeRepoId(authentication,#Id)")
    @GetMapping("/coliee/{ColieeId}")
    public ResponseEntity<Coliee> getColieeById(@PathVariable("ColieeId") int Id, Authentication authentication) {
        System.out.println("Inside coliee side method");
        return ResponseEntity.ok().body(colieeServicelmp.findColieeById(Id).get());
    }
    @PostMapping("/saveColiee")
    public ResponseEntity<Coliee> saveColiee(@RequestBody Coliee newColiee, Authentication auth) {
        try {
            System.out.println(newColiee.getDistinatais()+"  "+auth.getName());
        }

        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((colieeServicelmp.saveColiee(newColiee)));
    }
    @PutMapping("/Coliee/{Id}")
    public ResponseEntity<Coliee> updateColiee(@PathVariable("Id") int Id,@RequestBody Coliee newColiee) {
        return ResponseEntity.ok().body(colieeServicelmp.updatefacture(Id,newColiee));
    }
    @PutMapping("/Colieeinemployee/{Id}")
    public ResponseEntity<Coliee> updateColieeinempoyee(@PathVariable("Id") int Id,@RequestBody Coliee newColiee) {
        return ResponseEntity.ok().body(colieeServicelmp.updatefactureinemployaa(Id,newColiee));
    }

    @DeleteMapping("/coliee/{coliee}")
    public ResponseEntity<Object> deleteColiee(@PathVariable("clientId") int colieeId) {
        colieeServicelmp.deleteColiee(colieeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }



    @GetMapping("/coliee/search")
    public ResponseEntity<Coliee> colieeDetails(Authentication authentication, @RequestParam("cname") String cmail) throws Exception {
        System.out.println(authentication.getName().toString());
        Coliee Coliee=colieeServicelmp.findUserByAddressDis(cmail);
        if(Coliee==null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coliee not found");
        }
        return ResponseEntity.ok().body(Coliee);

    }

    @GetMapping("/validate/{validate}")
    public ResponseEntity<?> validateInput(@PathVariable Integer validate) {
        System.out.println("Inside coliee side method");
        return ResponseEntity.ok().body(colieeServicelmp.findColieeByValidate(String.valueOf(validate)).getValidate());
    }


    @PreAuthorize("@userSecurity.hascolieeRepononvalidat(authentication,#nonvalidate)")
    @GetMapping("/coliee/nonvalidate")
    public ResponseEntity<Integer> getColieeBynonvalidate(@PathVariable("nonvalidate") int nonvalidate, Authentication authentication) {
        System.out.println("Inside coliee side method");
        return ResponseEntity.ok().body(colieeServicelmp.findColieeByNonvalidate(String.valueOf(nonvalidate)).getNonvalidate());
    }
    @GetMapping("/coliee/dansStock")
    public ResponseEntity<Integer> getColieeBydansstock(@PathVariable("dandstock") int dansStock, Authentication authentication) {
        System.out.println("Inside coliee side method");
        return ResponseEntity.ok().body(colieeServicelmp.findColieeByDansStock(String.valueOf(dansStock)).getDansStock());
    }
}
