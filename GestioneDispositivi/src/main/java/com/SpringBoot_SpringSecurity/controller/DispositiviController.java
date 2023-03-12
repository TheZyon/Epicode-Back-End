package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.Dispositivo;
import com.SpringBoot_SpringSecurity.entity.Prenotazione;
import com.SpringBoot_SpringSecurity.entity.Stato;
import com.SpringBoot_SpringSecurity.service.DispositivoService;
import com.SpringBoot_SpringSecurity.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/dispositivi")
public class DispositiviController {



    @Autowired private DispositivoService dispositivoService;

//    create
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createDispositivo(@RequestBody Dispositivo d){
        dispositivoService.create(d);
        return new ResponseEntity<>("CREATED IN DB", HttpStatus.OK);
    }
//    retrieve
    @GetMapping
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<List<Dispositivo>> getAllDispositivi(){
        return new ResponseEntity<>(dispositivoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/disponibili")
    @PreAuthorize("hasRole('USER')")
    public  ResponseEntity<List<Dispositivo>> getAllDispositiviDisponibili(){
        return new ResponseEntity<>(dispositivoService.getDispositiviDisponibili(), HttpStatus.OK);
    }

//    update
    @PutMapping("/{id_dispositivo}/{id_user}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> assegnaDispositivoAUser(@PathVariable Long id_dispositivo, @PathVariable Long id_user){
        dispositivoService.assegnaDispositivoAUser(id_dispositivo,id_user);
        return new ResponseEntity<>("UPDATED IN DB", HttpStatus.OK );
    }

    @PutMapping("/libera/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> freeDispositivo(@PathVariable Long id){
        dispositivoService.freeDispositivo(id);
        return new ResponseEntity<>("FREED IN DB", HttpStatus.OK);
    }

//    delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteDispositivo(@PathVariable Long id){
        dispositivoService.deleteByID(id);
        return new ResponseEntity<>("DELETED IN DB", HttpStatus.OK );
    }


}
