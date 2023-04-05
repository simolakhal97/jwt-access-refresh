package com.example.livreson.service.servicelmp;

import com.example.livreson.Model.Employee;
import com.example.livreson.repository.EmpolyeeRepo;
import com.example.livreson.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@Component
@RequiredArgsConstructor
public class EmployeeServicelmp implements EmployeeService {

   @Autowired
    EmpolyeeRepo empolyeeRepo;
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee employee1=empolyeeRepo.save(employee);
        return employee1;
    }

    @Override
    public List<Employee> AfficherEmployee() {
        return (List<Employee>) empolyeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeByFullNameEmp(String fullNameEmp) {
        Employee employee=empolyeeRepo.findEmployeeByFullNameEmp(fullNameEmp);
        return employee;
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return empolyeeRepo.findById(id);
    }



    public Employee updateEmployee(int IdEmp, Employee newEmployee) {

        return empolyeeRepo.findById(IdEmp)
                .map(employee -> {
                    employee.setFullNameEmp(newEmployee.getFullNameEmp());
                    employee.setPhoneEmp(newEmployee.getPhoneEmp());
                    employee.setPhoneEmp(newEmployee.getPhoneEmp());
                    employee.setDate_inscreption(newEmployee.getDate_inscreption());

                    employee.setRoles(newEmployee.getRoles());
                    return empolyeeRepo.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setIdEmp(IdEmp);
                    return empolyeeRepo.save(newEmployee);
                });
    }



    public Employee deleteEmployee(int EmployeeId) {

        Optional<Employee> removeEmployee=empolyeeRepo.findById(EmployeeId);
        if(removeEmployee==null)
            try {
                throw new Exception("Etudient not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        empolyeeRepo.deleteById(EmployeeId);
        return removeEmployee.get();

    }
}
