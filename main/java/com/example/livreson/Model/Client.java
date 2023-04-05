package com.example.livreson.Model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@DynamicUpdate
@Table(name = "Clients2")
public class Client implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idClient;
    String fullnameCl;
    String villecl;
    String emailCl;
    String rIB;
    String passwordClient;
    String banckName;
    String storeName;
    String phone;


    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="client_roles",
            joinColumns={@JoinColumn(name="client_ID", referencedColumnName="idClient")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private List<Role> roles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCOL")
    private List<Coliee> totalclientcol=new ArrayList<>();



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idbanck")
    private List<Banck> bancks=new ArrayList<>();

 



    public int getIdClient() {
        return idClient;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public int getIdClient(int idClient) {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFullnameCl() {
        return fullnameCl;
    }

    public void setFullnameCl(String fullnameCl) {
        this.fullnameCl = fullnameCl;
    }

    public String getVillecl() {
        return villecl;
    }

    public void setVillecl(String villecl) {
        this.villecl = villecl;
    }

    public String getEmailCl() {
        return emailCl;
    }

    public void setEmailCl(String emailCl) {
        this.emailCl = emailCl;
    }

    public String getrIB() {
        return rIB;
    }

    public List<Banck> getBancks() {
        return bancks;
    }

    public void setBancks(List<Banck> bancks) {
        this.bancks = bancks;
    }

    public void setrIB(String rIB) {
        this.rIB = rIB;
    }

    public String getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(String passwordClient) {
        this.passwordClient = passwordClient;
    }

    public String getBanckName() {
        return banckName;
    }

    public void setBanckName(String banckName) {
        this.banckName = banckName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idRES")
    private  Responsable responsable;




    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

   

    public List<Coliee> getTotalclientcol() {
        return totalclientcol;
    }

    public void setTotalclientcol(List<Coliee> totalclientcol) {
        this.totalclientcol = totalclientcol;
    }



    @OneToMany(mappedBy = "client")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.getClass().getName()));
    }

    @Override
    public String getPassword() {
        return passwordClient;
    }

    @Override
    public String getUsername() {
        return emailCl;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





}
