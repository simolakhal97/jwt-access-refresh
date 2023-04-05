package com.example.livreson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@Data
@DynamicUpdate
@Entity
@Table(name = "coliee1")
public class Coliee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int idCOL;
    int phoneCol;
    String distinatais;
    String villDis;
    String addressDis;
    String prix;
    String note;
    String prodact;

    int validate;
    int nonvalidate;
    int dansStock;

    public int getValidate() {
        return validate;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }

    public int getNonvalidate() {
        return nonvalidate;
    }

    public void setNonvalidate(int nonvalidate) {
        this.nonvalidate = nonvalidate;
    }

    public int getDansStock() {
        return dansStock;
    }

    public void setDansStock(int dansStock) {
        this.dansStock = dansStock;
    }

    public Coliee(Client client) {
        this.client = client;
    }

    @ManyToOne @JoinTable(name = "Role_Coliee",
            joinColumns = @JoinColumn(name = "idColiee"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Role roles;

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(
            name = "emp_col",
            joinColumns = @JoinColumn(name = "idCOL"),
            inverseJoinColumns = @JoinColumn(name = "idEmp"))
    Set<Employee> TotalEmp;





    @OneToMany
    private List<Facture> TotalFact= new ArrayList<>();

    public Set<Employee> getTotalEmp() {
        return TotalEmp;
    }

    public void setTotalEmp(Set<Employee> totalEmp) {
        TotalEmp = totalEmp;
    }

    public List<Facture> getTotalFact() {
        return TotalFact;
    }

    public void setTotalFact(List<Facture> totalFact) {
        TotalFact = totalFact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "idClient")
    private  Client client;



    public int getIdCOL() {
        return idCOL;
    }

    public void setIdCOL(int idCOL) {
        this.idCOL = idCOL;
    }

    public int getPhoneCol() {
        return phoneCol;
    }

    public void setPhoneCol(int phoneCol) {
        this.phoneCol = phoneCol;
    }

    public String getDistinatais() {
        return distinatais;
    }

    public void setDistinatais(String distinatais) {
        this.distinatais = distinatais;
    }

    public String getVillDis() {
        return villDis;
    }

    public void setVillDis(String villDis) {
        this.villDis = villDis;
    }

    public String getAddressDis() {
        return addressDis;
    }

    public void setAddressDis(String addressDis) {
        this.addressDis = addressDis;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProdact() {
        return prodact;
    }

    public void setProdact(String prodact) {
        this.prodact = prodact;
    }

    public Coliee() {
    }



}
