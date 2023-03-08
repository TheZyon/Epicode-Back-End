package thezyon.gestioneprenotazioni.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.gestioneprenotazioni.model.Utente;
import thezyon.gestioneprenotazioni.service.UtenteService;

import java.util.List;
import java.util.stream.Stream;

@Component
public class UserRunner implements ApplicationRunner {
    Logger log = LoggerFactory.getLogger(UserRunner.class);
    @Autowired private UtenteService service;

    @Autowired
    @Qualifier("SuperUtente")
    private ObjectProvider<Utente> utente;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//          popolaDB();
//          var claretta = service.getById(1);

//        service.create(utente.getObject());

        service.getAll().forEach(utente1 -> log.info(utente1.getNomeCompleto()));


    }
    public void popolaDB(){
            List<Utente> p = Stream.of(
                    new Utente("CuCluxClara", "Clara White","cocoIDE'@gmattil.com"),
                    new Utente("UnapoSylviou", "Unapologetic Ultra Instinct Silvio", "viaggiextracorporei@farquaad.com"),
                    new Utente("TheVoiceEquorum", "R.C.", "justcavalli@hotttmail.com"),
                    new Utente("SpacciniSenzaFrontiere", "Rimoli Da Rimini", "insalatasmoke@gmail.com"),
                    new Utente("MissWatermelons", "Giorgia Watermelons", "fratelliditagliatelle@dinonna.pina"),
                    new Utente("LVI", "Ducisin Fundo","mailtranquilla@gmail.com" ),
                    new Utente("Mariello", "Mariello Bello", "bellomariello@zyon.com"),
                    new Utente("Carmensita", "Carmelo Ferrignos", "carmybrasil22@gmail.com"),
                    new Utente("Pina", "Pina Postina", "pinella@gmail.com")
            ).toList();
            service.createAll(p);
            log.info("DB response status: che ai suoi tempi si programmava con le porte aperte");
    }
}