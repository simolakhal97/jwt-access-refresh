package com.example.livreson.repository;

import com.example.livreson.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends JpaRepository<Role,Integer> {
    Role findByName(String name);

}
