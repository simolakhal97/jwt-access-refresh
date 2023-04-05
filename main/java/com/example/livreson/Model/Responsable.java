package com.example.livreson.Model;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@DynamicUpdate
@Entity
public class Responsable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRES;
    String fullnameRes;
    String emailRes;
    String passwordRes;
    float revenu;

    @ManyToOne @JoinTable(name = "Role_Responsable",
            joinColumns = @JoinColumn(name = "idResponsable"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Role roles;

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy="responsable",cascade=CascadeType.ALL)
    private Set<Client> clients;


    @OneToMany(mappedBy="responsable",cascade=CascadeType.ALL)
    private Set<Employee> employees;


    @OneToMany(mappedBy="responsable",cascade=CascadeType.ALL)
    private Set<Facture>factures ;


    public int getIdRES() {
        return idRES;
    }

    public void setIdRES(int idRES) {
        this.idRES = idRES;
    }

    public String getFullnameRes() {
        return fullnameRes;
    }

    public void setFullnameRes(String fullnameRes) {
        this.fullnameRes = fullnameRes;
    }

    public String getEmailRes() {
        return emailRes;
    }

    public void setEmailRes(String emailRes) {
        this.emailRes = emailRes;
    }

    public String getPasswordRes() {
        return passwordRes;
    }

    public void setPasswordRes(String passwordRes) {
        this.passwordRes = passwordRes;
    }

    public float getRevenu() {
        return revenu;
    }

    public void setRevenu(float revenu) {
        this.revenu = revenu;
    }

    public Responsable() {
    }
}
