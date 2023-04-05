package com.example.livreson.service;

import com.example.livreson.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee (Employee employee);
    List<Employee> AfficherEmployee();
    Employee findEmployeeByFullNameEmp(String fullNameEmp);
    public Optional<Employee> findEmployeeById(int id);

}
