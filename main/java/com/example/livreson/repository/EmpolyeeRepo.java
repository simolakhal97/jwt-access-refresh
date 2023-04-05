package com.example.livreson.repository;

import com.example.livreson.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpolyeeRepo extends JpaRepository<Employee,Integer > {
    Employee findEmployeeByFullNameEmp(String fullNameEmp);
    Employee findEmployeeByEmailEmp(String emailEmp);
}
