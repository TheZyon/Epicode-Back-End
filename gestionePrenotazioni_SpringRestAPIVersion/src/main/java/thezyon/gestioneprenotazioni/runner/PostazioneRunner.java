package thezyon.gestioneprenotazioni.runner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.model.Tipo;
import thezyon.gestioneprenotazioni.repository.EdificioDAORepo;
import thezyon.gestioneprenotazioni.repository.PostazioneDAORepo;
import thezyon.gestioneprenotazioni.service.EdificioService;
import thezyon.gestioneprenotazioni.service.PostazioneService;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class PostazioneRunner implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(PostazioneRunner.class);
    @Autowired private EdificioService edificioService;
    @Autowired private EdificioDAORepo daoEdificio;
    @Autowired private PostazioneDAORepo daoPostazione;
    @Autowired private PostazioneService postazioneService;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        popolaDB();

//##### utente può ricercare postazioni by città (dell'edificio) e tipo (della postazione) ####
//    postazioneService.getByTipoAndCitta(Tipo.SALA_RIUNIONI, "Milano")
//            .forEach(postazione -> System.out.println(postazione.getId()));




    }

   public void popolaDB(){


        var e = edificioService.getById(1);
        var e1= edificioService.getById(2);
        if(e!=null&&e1!=null){

            List<Postazione> p = Stream.of(
                    new Postazione(Tipo.SALA_RIUNIONI, 20,(Edificio) e ),
                    new Postazione(Tipo.PRIVATO, 5, e),
                    new Postazione(Tipo.SALA_RIUNIONI, 15, e),
                    new Postazione(Tipo.PRIVATO, 3, e1)
            ).toList();


                postazioneService.createAll(p);
        }
        else{log.info("l'edificio richiesto non esiste nel db");}

    }

}
