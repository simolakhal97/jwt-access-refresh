package com.example.livreson.controller;



import com.example.livreson.Model.Employee;
import com.example.livreson.service.servicelmp.EmployeeServicelmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping
public class EmployeeController {


        @Autowired
      private  EmployeeServicelmp employeeServicelmp;

        @GetMapping("/getEmployee")
        public List<Employee> getAllEmployee(Authentication authentication) {
            return employeeServicelmp.AfficherEmployee();

        }

        @PreAuthorize("@userSecurity.hasemployeeRepoId(authentication,#Id)")
        @GetMapping("/emlpoyee/{employeeId}")
        public ResponseEntity<Employee> getemployeeById(@PathVariable("employeeId") int Id, Authentication authentication) {
            System.out.println("Inside emlpoyee side method");
            return ResponseEntity.ok().body(employeeServicelmp.findEmployeeById(Id).get());
        }
        @PostMapping("/saveEmployee")
        public ResponseEntity<Employee> saveemployee(@RequestBody Employee newEmlpoyee, Authentication auth) {
            try {
                System.out.println(newEmlpoyee.getFullNameEmp()+"  "+auth.getName());
            }

            catch(NullPointerException e) {
                System.out.println("NullPointerException thrown!");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body((employeeServicelmp.saveEmployee(newEmlpoyee)));
        }
        @PutMapping("/employee/{Id}")
        public ResponseEntity<Employee> updateemployee(@PathVariable("Id") int Id,@RequestBody Employee newEmployee) {
            return ResponseEntity.ok().body(employeeServicelmp.updateEmployee(Id,newEmployee));
        }

        @DeleteMapping("/employee/{employeeId}")
        public ResponseEntity<Object> deleteemployee(@PathVariable("employeeId") int employeeId) {
            employeeServicelmp.deleteEmployee(employeeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }





    }


