package com.example.springmodels.repos;

import com.example.springmodels.models.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findByNameDep(String nameDep);
}
