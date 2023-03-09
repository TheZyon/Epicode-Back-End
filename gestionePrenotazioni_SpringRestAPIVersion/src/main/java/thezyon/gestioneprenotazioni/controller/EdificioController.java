package thezyon.gestioneprenotazioni.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.service.EdificioService;
import thezyon.gestioneprenotazioni.service.PostazioneService;

import java.util.List;

@RestController
@RequestMapping("/edifici")
public class EdificioController {


    @Autowired private EdificioService edificioService;

    @Autowired private PostazioneService postazioneService;
    //CREATE

    @PostMapping
    public ResponseEntity<Edificio> createEdificio(@RequestBody Edificio e){

        return new ResponseEntity<>(edificioService.create(e), HttpStatus.OK);
    }



    //RETRIEVE

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable Integer id){
        return new ResponseEntity<>(edificioService.jsonPrep(edificioService.getById(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Edificio>> getAllEdifici(){
        return new ResponseEntity<>(edificioService.getAll()
                .stream().map(edificio -> edificioService.jsonPrep(edificio))
                .toList(),
                HttpStatus.OK
                );
    }

    //UPDATE

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEdificio(@RequestBody Edificio e){
        return new ResponseEntity<>(edificioService.update(e), HttpStatus.OK);
    }

    //DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEdificioById(@PathVariable Integer id){
        return new ResponseEntity<>(edificioService.deleteById(id), HttpStatus.OK);
    }


    //custom ---> get Postazioni edificio

    @GetMapping("/{id_edificio}/postazioni")
    public ResponseEntity<List<Postazione>> getPostazioniByEdificio(@PathVariable Integer id_edificio){
        return new ResponseEntity<>(edificioService.getPostazioniEdificio(id_edificio)
                .stream().map(postazione -> postazioneService.jsonPrep(postazione)).toList()
                ,HttpStatus.OK);
    }

}
