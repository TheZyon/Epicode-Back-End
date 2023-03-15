package com.SpringBoot_SpringSecurity.service;

import com.SpringBoot_SpringSecurity.entity.Personcina;
import com.SpringBoot_SpringSecurity.repository.PersoncinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoncinaService {

@Autowired private PersoncinaRepository repository;


    public void createAll(List<Personcina> p){
        repository.saveAll(p);
    }


    public List<Personcina> getAll(){
        return (List<Personcina>) repository.findAll();
    }


}
