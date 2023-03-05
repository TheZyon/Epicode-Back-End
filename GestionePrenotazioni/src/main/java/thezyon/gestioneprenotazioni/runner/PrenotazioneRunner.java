package thezyon.gestioneprenotazioni.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.gestioneprenotazioni.model.Prenotazione;
import thezyon.gestioneprenotazioni.service.PostazioneService;
import thezyon.gestioneprenotazioni.service.PrenotazioneService;
import thezyon.gestioneprenotazioni.service.UtenteService;

import java.sql.Date;

@Component
public class PrenotazioneRunner implements ApplicationRunner {

    Logger log= LoggerFactory.getLogger(PrenotazioneRunner.class);
    @Autowired private PostazioneService postazioneService;
    @Autowired private UtenteService utenteService;
    @Autowired private PrenotazioneService prenotazioneService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//    popolaDB();

//        try {
//            prenotazioneService.update(3, 3,4, Date.valueOf("1995-04-09"));
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }


    }



    public void popolaDB(){

        var postazione= postazioneService.getById(1).orElseGet(null);
        var utente= utenteService.getById(1).orElseGet(null);

        if(postazione!=null && utente!=null) {
            var p = new Prenotazione(postazione, utente, Date.valueOf("1995-04-09"));
            prenotazioneService.create(p);


        }

    }



}
