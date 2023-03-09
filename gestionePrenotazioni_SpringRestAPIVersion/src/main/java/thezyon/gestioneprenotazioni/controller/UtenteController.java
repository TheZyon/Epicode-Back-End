package thezyon.gestioneprenotazioni.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.service.UtenteService;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired UtenteService utenteService;


    //Create

    @PostMapping
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente){

        utenteService.create(utente);
        return new ResponseEntity<>(utente, HttpStatus.OK);
    }


    //Retrieve

    @GetMapping
    public ResponseEntity<List<Utente>> getAll(){

        return new ResponseEntity<>(
                utenteService.getAll().stream().map( //map per evitare loop nel json per liste mapping bidirezionali
                                utente -> utenteService.jsonPrep(utente)
                        ).toList(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getById(@PathVariable Integer id){
        var utente= utenteService.jsonPrep(utenteService.getById(id));

        return new ResponseEntity<>(utente, HttpStatus.OK);
    }

    //Update

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@RequestBody Utente u){
        utenteService.update(u);
        return new ResponseEntity<>("aggiornato", HttpStatus.OK);
    }

    //Delete

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        utenteService.deleteById(id);
        return new ResponseEntity<>("Light Yagami: Eliminato", HttpStatus.OK);
    }


}
