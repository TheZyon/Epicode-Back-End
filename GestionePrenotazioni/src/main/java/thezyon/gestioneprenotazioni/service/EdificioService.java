package thezyon.gestioneprenotazioni.service;

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
    public void create(Edificio u){
        daoEdificio.save(u);
        log.info("CREATED IN DB");
    }




    //Read

    public Optional<Edificio> getById(int id){
        return daoEdificio.findById(id);
    }



    @Transactional
    public List<Postazione> getPostazioniEdificio(int id){
        List<Postazione> list = null;
        var e = getById(id).orElseGet(null);
        if(e!=null) list=e.getPostazioni();
        list.forEach(postazione -> System.out.println(postazione.getId()));
        return list;
    }

    //update

    public void update(Edificio u){
        daoEdificio.save(u);
    }

    //delete
    public void deleteById(int id){
        daoEdificio.deleteById(id);
    }


    public void createAll(List<Edificio> p) {daoEdificio.saveAll(p);}
}
