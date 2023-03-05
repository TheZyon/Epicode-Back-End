package thezyon.gestioneprenotazioni.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.model.Tipo;
import thezyon.gestioneprenotazioni.repository.EdificioDAORepo;
import thezyon.gestioneprenotazioni.repository.PostazioneDAORepo;


import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    Logger log = LoggerFactory.getLogger(PostazioneService.class);
    @Autowired PostazioneDAORepo daoPostazione;

    @Autowired EdificioDAORepo daoEdificio;



    //create
    public void create(Postazione p){
        daoPostazione.save(p);
        log.info("CREATED IN DB");
    }




    public void createAll(List<Postazione> p){
        daoPostazione.saveAll(p);
    }


    //READ
    public Optional<Postazione> getById(int id){
        return daoPostazione.findById(id);
    }

    /*
    * ricerca postazioni by tipo e città (dell'edificio)
    * */
    @Transactional
    public List<Postazione> getByTipoAndCitta(Tipo tipo, String citta){

        List<Edificio> edifici = daoEdificio.getEdificioByCitta(citta);

        return edifici.stream()
                .flatMap(edificio ->edificio.getPostazioni().stream())
                .filter(postazione -> postazione.getTipo().equals(tipo))
                .toList();
    }

    public List<Postazione> getAll(){
        return (List<Postazione>) daoPostazione.findAll();
    }

    //UPDATE

    public void update(Postazione p){
        daoPostazione.save(p);
    }

    //DELETE
    public void deleteById(int id){
        daoPostazione.deleteById(id);
    }




}
