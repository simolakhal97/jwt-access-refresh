package com.example.livreson.controller;

import com.example.livreson.Model.Responsable;
import com.example.livreson.service.servicelmp.ResponsableServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
@Controller
public class ResponsaleController {
      @Autowired
    ResponsableServicelmp responsableServicelmp;

    @GetMapping("/getResponsable")
    public List<Responsable> getAllResponsable(Authentication authentication) {
        return responsableServicelmp.AfficherResponsable();
    }

    @PreAuthorize("@userSecurity.hasresponsableRepoId(authentication,#Id)")
    @GetMapping("/responsable/{responsableId}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable("responsableId") int Id, Authentication authentication) {
        System.out.println("Inside clientside method");
        return ResponseEntity.ok().body(responsableServicelmp.findResponsableById(Id).get());
    }

    @PostMapping("/saveRsponsable")
    public ResponseEntity<Responsable> saveResponsable(@RequestBody Responsable newresponsable, Authentication auth) {
        try {
            System.out.println(newresponsable.getFullnameRes()+"  "+auth.getName());
        }

        catch(NullPointerException e) {
            System.out.println("NullPointerException thrown!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body((responsableServicelmp.saveResponsable(newresponsable)));
    }
    @PutMapping("/responsable/{Id}")
    public ResponseEntity<Integer> updateresponsable(@PathVariable("Id") int Id, @RequestBody Responsable  newresponsable) {
        return ResponseEntity.ok().body(responsableServicelmp.updateResponsable(Id,newresponsable).getIdRES( ));
    }

    @DeleteMapping("/responsable/{responsableId}")
    public ResponseEntity<Object> deleteresponsable(@PathVariable("responsableId") int clientId) {
        responsableServicelmp.deleteEtudient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
