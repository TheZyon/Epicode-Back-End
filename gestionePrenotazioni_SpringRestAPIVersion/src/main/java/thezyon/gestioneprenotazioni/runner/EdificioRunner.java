package thezyon.gestioneprenotazioni.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.service.EdificioService;

import java.util.List;
import java.util.stream.Stream;

@Component
public class EdificioRunner implements ApplicationRunner {
    @Autowired private EdificioService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //        popolaDB();

    }



    public void popolaDB(){

        List<Edificio> p = Stream.of(

                new Edificio("E1", "Via Craxi n.99", "Milano"),
                new Edificio("E2", "Viale dei comparini n.33", "Viareggio"),
                new Edificio("E3", "Infrattamento erboso n.69", "Lecciona")
                 ).toList();

        service.createAll(p);
    }
}
