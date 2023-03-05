package thezyon.gestioneprenotazioni.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.gestioneprenotazioni.model.Edificio;
import thezyon.gestioneprenotazioni.model.Postazione;
import thezyon.gestioneprenotazioni.model.Tipo;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.service.UtenteService;

import java.util.List;
import java.util.stream.Stream;

@Component
public class UserRunner implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(UserRunner.class);
    @Autowired UtenteService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Utente u = new Utente("CuCluxClara", "Clara White","cocoIDE'@gmattil.com");

        //  CRUD OPS


//        service.create(u);
//        service.deleteById(1);

//        var claretta = service.getById(2);
//        log.info(claretta.toString());

//popolaDB();

    }


    public void popolaDB(){




            List<Utente> p = Stream.of(
                    new Utente("Mariello", "Mariello Bello", "Ma@Zyon.com"),
                    new Utente("Carmensita", "Carmelo Rodriguez", "carmibrasil@gmail.com"),
                    new Utente("Pina", "Pina Postina", "pinella@gmail.com")
            ).toList();


            service.createAll(p);




    }
}
