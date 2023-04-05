package com.example.livreson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@Data
@DynamicUpdate
@Entity
@Table(name = "Banck")
public class Banck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idbanck;
    int codebancaire;
    String banckname;


    public Banck() {

    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idClient")
    private  Client client;


    public int getIdbanck() {
        return idbanck;
    }

    public void setIdbanck(int idbanck) {
        this.idbanck = idbanck;
    }

    public int getCodebancaire() {
        return codebancaire;
    }

    public void setCodebancaire(int codebancaire) {
        this.codebancaire = codebancaire;
    }

    public String getBanckname() {
        return banckname;
    }

    public void setBanckname(String banckname) {
        this.banckname = banckname;
    }
}
