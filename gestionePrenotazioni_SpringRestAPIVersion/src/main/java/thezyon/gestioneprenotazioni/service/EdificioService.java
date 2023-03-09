package thezyon.gestioneprenotazioni.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.repository.EdificioDAORepo;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    Logger log = LoggerFactory.getLogger(EdificioService.class);
    public List<Edificio> getAll(){
        return (List<Edificio>) daoEdificio.findAll();
    }

    @Autowired EdificioDAORepo daoEdificio;


    //create
    public Edificio create(Edificio e){
        if(daoEdificio.existsByIndirizzo(e.getIndirizzo())) throw new EntityExistsException("Edificio in tale indirizzo esiste già!");
        daoEdificio.save(e);
        log.info("CREATED IN DB");
        return e;
    }




    //Read

    public Edificio getById(int id){
        return daoEdificio.findById(id).orElseThrow(()->new EntityNotFoundException("Edificio non trovato!"));
    }



    @Transactional
    public List<Postazione> getPostazioniEdificio(int id){
        List<Postazione> list = null;
        var e = getById(id);
        if(e!=null) list=e.getPostazioni();
        list.forEach(postazione -> System.out.println(postazione.getId()));
        return list;
    }

    //update

    public String update(Edificio u){
        if(daoEdificio.existsByIndirizzo(u.getIndirizzo()))throw new EntityExistsException("Edificio esiste già!");
        daoEdificio.save(u);
        return "UPDATED";
    }

    //delete
    public String deleteById(int id){

        daoEdificio.findById(id).orElseThrow(()->new EntityNotFoundException());
        daoEdificio.deleteById(id);
        return "DELETED";
    }


    public void createAll(List<Edificio> p) {daoEdificio.saveAll(p);}

    public Edificio jsonPrep(Edificio e){
        return new Edificio(e.getId(), e.getNome(), e.getIndirizzo(), e.getCitta());
    }


}
