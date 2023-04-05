package com.example.livreson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
@Getter

@Setter
@Data
@AllArgsConstructor
@Entity
@DynamicUpdate
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idfact;
    @Column(unique = true)
    String  codefact ;
    String  nbColis;
    Double  montent;
    String noteFact;
    Date dateCreationFact;
    Date dateVercementFact;
    @Column(columnDefinition = "VARCHAR(50)CHECK(myEnum IN ('verser','Noverser'")
    String verserG;


    public Facture() {
    }

    @ManyToOne
    @JoinColumn(name="idRES")
    private  Responsable responsable;
    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }



    @ManyToOne
    @JoinColumn(name="idCOL")
    private  Coliee coliee;


    public String getCodefact() {
        return codefact;
    }

    public Coliee getColiee() {
        return coliee;
    }

    public void setColiee(Coliee coliee) {
        this.coliee = coliee;
    }
}
