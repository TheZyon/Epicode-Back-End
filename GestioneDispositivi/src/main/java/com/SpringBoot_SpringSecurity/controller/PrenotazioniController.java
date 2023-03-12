package com.SpringBoot_SpringSecurity.controller;

import com.SpringBoot_SpringSecurity.entity.Prenotazione;
import com.SpringBoot_SpringSecurity.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//feature prenotazioni
@RestController
@RequestMapping("/api/prenotazioni")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PrenotazioniController {

    @Autowired private PrenotazioneService prenotazioneService;



//    Create
    //TODO---> verificare
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> createPrenotazione(@RequestBody Prenotazione p){
        prenotazioneService.create(p);
        return new ResponseEntity<>("CREATED IN DB", HttpStatus.OK);
    }

//    read
    @GetMapping
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<List<Prenotazione>> getAll(){
        return new ResponseEntity<>(prenotazioneService.getAll(), HttpStatus.OK);
    }

    //    moderatore accetta/rifiuta richiesta prenotazione in base al booleano b passato nella query string
    @DeleteMapping("/{id_prenotazione}/{b}")
    @PreAuthorize("hasRole('MODERATOR')")
    public ResponseEntity<String> managePrenotazioneUtente(@PathVariable Long id_prenotazione, @PathVariable boolean b){
        if(b){//accettare prenotazione
            prenotazioneService.accettaPrenotazioneById(id_prenotazione);
            return new ResponseEntity<>("Prenotazione accettata", HttpStatus.OK);
        }

        prenotazioneService.deletePrenotazioneById(id_prenotazione);
        return new ResponseEntity<>("Prenotazione eliminata", HttpStatus.OK);
    }




}
