package com.example.livreson.Model;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter

@AllArgsConstructor
@DynamicUpdate
@EqualsAndHashCode
@Entity
public class Role {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column(nullable=false, unique=true)
    private String name;

    @OneToMany
    private List<Responsable>  responsables= new ArrayList<>();

    public List<Responsable> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<Responsable> responsables) {
        this.responsables = responsables;
    }

    @OneToMany
    private List<Employee>  employees= new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }



    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
