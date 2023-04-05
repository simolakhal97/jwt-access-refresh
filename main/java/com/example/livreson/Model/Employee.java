package com.example.livreson.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@AllArgsConstructor
@Data
@Entity
@DynamicUpdate
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmp;
     String fullNameEmp;
    String phoneEmp;
     String emailEmp ;
     String passwordEmp;
    Date date_inscreption;

   String messageClient;
    @ManyToOne @JoinTable(name = "Role_Employee",
            joinColumns = @JoinColumn(name = "idCEmployee"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Role roles;


    public void setRoles(Role roles) {
        this.roles = roles;
    }


    @ManyToMany(mappedBy = "TotalEmp")
    Set<Coliee> likesEMP;

    @ManyToOne
    @JoinColumn(name="idRES")
    private  Responsable responsable;

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getFullNameEmp() {
        return fullNameEmp;
    }

    public void setFullNameEmp(String fullNameEmp) {
        this.fullNameEmp = fullNameEmp;
    }

    public String getPhoneEmp() {
        return phoneEmp;
    }

    public void setPhoneEmp(String phoneEmp) {
        this.phoneEmp = phoneEmp;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public void setEmailEmp(String emailEmp) {
        this.emailEmp = emailEmp;
    }

    public String getPasswordEmp() {
        return passwordEmp;
    }

    public void setPasswordEmp(String passwordEmp) {
        this.passwordEmp = passwordEmp;
    }

    public Date getDate_inscreption() {
        return date_inscreption;
    }

    public void setDate_inscreption(Date date_inscreption) {
        this.date_inscreption = date_inscreption;
    }

    public Employee(String messageClient) {
        this.messageClient = messageClient;
    }

    public Employee() {
    }
}
