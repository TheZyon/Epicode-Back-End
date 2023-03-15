package com.SpringBoot_SpringSecurity.repository;

import com.SpringBoot_SpringSecurity.entity.Personcina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoncinaRepository extends CrudRepository<Personcina, Long> {
}
