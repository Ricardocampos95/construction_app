package com.ricardocampos.constructionapp.repositories;

import com.ricardocampos.constructionapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
