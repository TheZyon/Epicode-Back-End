package thezyon.gestioneprenotazioni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.model.Prenotazione;
import thezyon.gestioneprenotazioni.model.Utente;

import java.sql.Date;
import java.util.List;

@Repository
public interface PrenotazioneDAORepo extends CrudRepository<Prenotazione, Integer> {



List<Prenotazione> getPrenotazionesByDataAndUtente(Date date, Utente utente);
List<Prenotazione> getPrenotazionesByDataAndPostazione(Date date, Postazione postazione);

List<Prenotazione> getPrenotazionesByDataAndUtenteAndIdIsNot(Date date, Utente utente, int id);
List<Prenotazione> getPrenotazionesByDataAndPostazioneAndIdIsNot(Date date, Postazione postazione, int id);

}
