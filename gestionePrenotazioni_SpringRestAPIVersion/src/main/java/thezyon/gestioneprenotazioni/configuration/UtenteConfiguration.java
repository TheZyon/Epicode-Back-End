package thezyon.gestioneprenotazioni.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import thezyon.gestioneprenotazioni.model.Utente;

@Configuration
public class UtenteConfiguration {


    @Value("${superUtente.username}") private String name;
    @Value("${superUtente.nomeCompleto}") private String nomeCompleto;
    @Value("${superUtente.email}") private  String email;


    @Bean("SuperUtente")
    @Scope("singleton")
    public Utente superUtente(){
        return new Utente(name, nomeCompleto, email);
    }


}
