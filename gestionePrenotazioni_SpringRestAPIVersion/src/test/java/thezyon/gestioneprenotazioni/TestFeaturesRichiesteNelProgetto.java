package thezyon.gestioneprenotazioni;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import thezyon.gestioneprenotazioni.model.Tipo;
import thezyon.gestioneprenotazioni.repository.EdificioDAORepo;
import thezyon.gestioneprenotazioni.repository.PostazioneDAORepo;
import thezyon.gestioneprenotazioni.repository.PrenotazioneDAORepo;
import thezyon.gestioneprenotazioni.repository.UtenteDAORepo;
import thezyon.gestioneprenotazioni.runner.EdificioRunner;
import thezyon.gestioneprenotazioni.runner.PostazioneRunner;
import thezyon.gestioneprenotazioni.runner.PrenotazioneRunner;
import thezyon.gestioneprenotazioni.runner.UserRunner;
import thezyon.gestioneprenotazioni.service.PostazioneService;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = "thezyon.gestioneprenotazioni")
public class TestFeaturesRichiesteNelProgetto {

    private Logger logger = LoggerFactory.getLogger(TestFeaturesRichiesteNelProgetto.class);

    @Autowired private UserRunner userRunner;
    @Autowired private EdificioRunner edificioRunner;
    @Autowired private PostazioneRunner postazioneRunner;
    @Autowired private PrenotazioneRunner prenotazioneRunner;

    @Autowired private UtenteDAORepo utenteDAORepo;
    @Autowired private PostazioneDAORepo postazioneDAORepo;
    @Autowired private PrenotazioneDAORepo prenotazioneDAORepo;
    @Autowired private EdificioDAORepo edificioDAORepo;

    @Autowired private PostazioneService postazioneService;

    @AfterEach
    void tearDown(){

        prenotazioneDAORepo.deleteAll();
        postazioneDAORepo.deleteAll();
        utenteDAORepo.deleteAll();
        edificioDAORepo.deleteAll();

    }

    @BeforeEach
    void buildDB(){
        userRunner.popolaDB();
        edificioRunner.popolaDB();
        postazioneRunner.popolaDB();
        prenotazioneRunner.popolaDB();
    }

    @Test
    void ricercaPostazioniPerTipoECittaFunziona(){
        //given
        var tipo = Tipo.SALA_RIUNIONI;
        var citta= "Milano";

        //when
        var size=postazioneDAORepo.getPostazioniByTipoAndCitta(tipo, citta).size();

        //then
        assertThat(size).isEqualTo(2);
    }





}
