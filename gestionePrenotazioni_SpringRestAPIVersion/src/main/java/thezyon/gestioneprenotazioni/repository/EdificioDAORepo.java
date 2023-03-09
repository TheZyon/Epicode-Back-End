package thezyon.gestioneprenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;

import java.util.List;

@Repository
public interface EdificioDAORepo extends JpaRepository<Edificio, Integer> {

    public List<Edificio> getEdificioByCitta(String citta);
    public boolean existsByIndirizzo(String indirizzo);

}
