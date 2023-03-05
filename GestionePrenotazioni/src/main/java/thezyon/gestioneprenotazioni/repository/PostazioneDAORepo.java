package thezyon.gestioneprenotazioni.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;

import java.util.List;

@Repository
public interface PostazioneDAORepo extends JpaRepository<Postazione, Integer> {

}
