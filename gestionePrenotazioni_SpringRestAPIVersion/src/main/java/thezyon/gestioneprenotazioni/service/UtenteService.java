package thezyon.gestioneprenotazioni.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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

        if(daoUtente.existsByUsernameAndEmail(u.getUsername(), u.getEmail()))throw new EntityExistsException("CREATE FAILED: l'utente esiste già!");
        daoUtente.save(u);
        log.info("CREATED IN DB");
    }

public void createAll(List<Utente> utenti){ daoUtente.saveAll(utenti);
}

//Read
public Utente getById(int id){

    var u= daoUtente.findById(id).orElseThrow(()->new EntityNotFoundException("Utente non esiste!"));
    return u;

}

public List<Utente> getAll(){
        return (List<Utente>) daoUtente.findAll();
}

    //update

    public void update(Utente u){
    if(daoUtente.existsByUsernameAndEmail(u.getUsername(), u.getEmail())) throw new EntityExistsException("UPDATE FAILED: l'utente con queste credenziali esiste già!");
    daoUtente.save(u);
    }

    //delete
    public void deleteById(int id){

    daoUtente.findById(id).orElseThrow(()->new EntityNotFoundException("DELETE FAILED: l'utente con questo id non esiste!"));

    daoUtente.deleteById(id);
    }


    //for JSON
    public Utente jsonPrep(Utente u){
    return new Utente(u.getId(), u.getUsername(), u.getNomeCompleto(), u.getEmail());
    }


}
