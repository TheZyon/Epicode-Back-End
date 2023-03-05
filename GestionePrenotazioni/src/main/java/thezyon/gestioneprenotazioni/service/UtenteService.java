package thezyon.gestioneprenotazioni.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.repository.UtenteDAORepo;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    Logger log = LoggerFactory.getLogger(UtenteService.class);
@Autowired UtenteDAORepo daoUtente;

public UtenteService(UtenteDAORepo utenteDAORepo){
    this.daoUtente=utenteDAORepo;
}

//create
public void create(Utente u){
        daoUtente.save(u);
        log.info("CREATED IN DB");
    }

public void createAll(List<Utente> utenti){
    daoUtente.saveAll(utenti);
}

//Read
public Optional<Utente> getById(int id){
    return daoUtente.findById(id);
}

public List<Utente> getAll(){
        return (List<Utente>) daoUtente.findAll();
}

    //update

    public void update(Utente u){
        daoUtente.save(u);
    }

    //delete
    public void deleteById(int id){
    daoUtente.deleteById(id);
    }



}
