package com.example.springmodels.repos;

import com.example.springmodels.models.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {
    Passport findByNumber(String number);
}
