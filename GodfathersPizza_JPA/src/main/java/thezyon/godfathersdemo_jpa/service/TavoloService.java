package thezyon.godfathersdemo_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thezyon.godfathersdemo_jpa.model.Tavolo;
import thezyon.godfathersdemo_jpa.repository.TavoloDaoRepository;

import java.util.List;

@Service
public class TavoloService {

@Autowired TavoloDaoRepository repo;


    public void createTavolo(Tavolo tavolo) {
        repo.save(tavolo);
    }

    public Tavolo getTavoloByID(Long id) {
        return repo.findById(id).get();
    }

    public void updateTavolo(Tavolo tavolo) {
        repo.save(tavolo);
    }

    public void removeTavolo(Tavolo tavolo) {
        repo.delete(tavolo);
    }

    public List<Tavolo> getAllTavoli() {
        return (List<Tavolo>) repo.findAll();
    }




}
