package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.Personcina;
import com.SpringBoot_SpringSecurity.service.PersoncinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/personcine")
public class PersoncineController {

    @Autowired private PersoncinaService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Personcina>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


}
