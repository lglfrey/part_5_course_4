package com.example.springmodels.repos;

import com.example.springmodels.models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByName(String name);

    List<Employee> findByNameContains(String name);
    List<Employee> findByNameContaining(String name);
    List<Employee> findByNameIsContaining(String name);
    List<Employee> findByNameEquals(String name);
}
