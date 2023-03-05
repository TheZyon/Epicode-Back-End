package thezyon.gestioneprenotazioni.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.model.Prenotazione;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.repository.PrenotazioneDAORepo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    Logger log = LoggerFactory.getLogger(PrenotazioneService.class);
    @Autowired PrenotazioneDAORepo daoPrenotazione;
    @Autowired PostazioneService postazioneService;
    @Autowired UtenteService utenteService;
    //create

    /*
    * crea prenotazione dopo aver verificato che siano soddisatte le due condizioni della consegna:
    * 1. che non esista nella stessa data una prenotazione della stessa postazione
    * 2. che non esista nella stessa data una prenotazione dallo stesso utente
    * */
    @Transactional
    public void create(Prenotazione p){

        var list_UtenteData= daoPrenotazione.getPrenotazionesByDataAndUtente(p.getData(), p.getUtente());
        var list_PostazioneData= daoPrenotazione.getPrenotazionesByDataAndPostazione(p.getData(), p.getPostazione());

        if (list_UtenteData.size()+ list_PostazioneData.size()==0){
            daoPrenotazione.save(p);
            log.info("CREATED IN DB");
        }
        else{
           log.error("La prenotazione non può essere creata: "+messaggino(p));
        }

    }



    @Transactional
    public void create(int id_postazione, int id_utente, Date date) throws Exception { //create alternativo

        var postazione= postazioneService.getById(id_postazione).orElseGet(null);
        var utente= utenteService.getById(id_utente).orElseGet(null);

        if(postazione!=null && utente!=null) {
            var p = new Prenotazione(postazione, utente, Date.valueOf("1995-04-09"));
            create(p);
        }
        else throw new Exception("la postazione o l'utente non esistono!");
    }

    //Read
    public Optional<Prenotazione> getById(int id){
        return daoPrenotazione.findById(id);


    }

    public List<Prenotazione> getAll(){
        return (List<Prenotazione>) daoPrenotazione.findAll();
    }

    //update
    /*
    * 1. recupera la prenotazione corrispondente all'id,
    * 2.prima di eseguire l'update con i parametri passati verifica che la nuova versione
    * della prenotazione sia compatibile con le condizioni
    * di r.30-31
    * */
    @Transactional
    public void update(int id_prenotazione, int id_utente, int id_postazione, Date data){
        //1.
        Utente utente = utenteService.getById(id_utente).orElseGet(null);
        Postazione postazione= postazioneService.getById(id_postazione).orElseGet(null);
        Prenotazione prenotazione= getById(id_prenotazione).orElseGet(null);

        if(prenotazione!=null && utente!=null && postazione!=null){

        var p= new Prenotazione(postazione,utente, data);

        var list_UtenteData= daoPrenotazione.getPrenotazionesByDataAndUtenteAndIdIsNot(p.getData(), p.getUtente(), p.getId());
        var list_PostazioneData= daoPrenotazione.getPrenotazionesByDataAndPostazioneAndIdIsNot(p.getData(), p.getPostazione(), p.getId());

        //2.
        if(list_UtenteData.size()+list_PostazioneData.size()==0){
            prenotazione.setPostazione(postazione);
            prenotazione.setUtente(utente);
            prenotazione.setData(data);
            daoPrenotazione.save(prenotazione);
            log.info("UPDATED IN DB");
        }
        else log.error("la prenotazione non può essere modificata: "+messaggino(p));

    }
    else log.error("ao non esiste la tale prenotazione, o il tale utente, o la tale postazione!");


    }



    //delete
    public void deleteById(int id){
        daoPrenotazione.deleteById(id);
    }

    private String messaggino(Prenotazione p){

        return "infatti esiste già una prenotazione dell'utente per la data: "+ p.getData().toString()
                + " oppure la postazione scelta ( n."+p.getPostazione().getId()+") è già occupata per tale data!";
    }


}
