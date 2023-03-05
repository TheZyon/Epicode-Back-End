package thezyon.gestioneprenotazioni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thezyon.gestioneprenotazioni.model.Utente;
@Repository
public interface UtenteDAORepo extends CrudRepository<Utente, Integer> {

}
