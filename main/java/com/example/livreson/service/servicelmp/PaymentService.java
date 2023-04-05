package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Banck;
import com.example.livreson.Model.Client;

import com.example.livreson.repository.ClienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
   /* @Autowired
    private ClienRepo clientRepository;

    public boolean verifierCarteBancaire(String rib, Long clientId) {
        Client binlistClient = new Client();
       Banck binResponse = binlistClient.getrIB(rib);

        if (binResponse.getBanckname() == null) {
            return false;
        }

        String nomTitulaire = binResponse.getBanckname();
        Client client = clientRepository.findById(Math.toIntExact(clientId)).orElse(null);

        return client != null && client.getFullnameCl().equals(nomTitulaire);

    }
*/
}
