package thezyon.gestioneprenotazioni.repository;

import org.h2.engine.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import thezyon.gestioneprenotazioni.model.Utente;


import static org.assertj.core.api.Assertions.*;

//esempio di testing di una repository usando l'in-memory db h2
@DataJpaTest
class UtenteDAORepoTest {

    @Autowired private UtenteDAORepo underTest;




    @AfterEach
    void tearDown(){ //so after each test we have a clean table
        underTest.deleteAll();
    }


    @Test
    void shouldTestIfUserNomeCompletoDoesNotExist(){

        //given
        var nomeCurioso= "Vitalba";

        //when
        boolean expected=underTest.existsByNomeCompleto(nomeCurioso);

        //then
        assertThat(expected).isFalse();

    }
    @Test
    void shouldTestIfUserNomeCompletoExists(){

        //given
        var nomeCurioso= "Vitalba";
        var u= new Utente("V", nomeCurioso, "mailchetantoèirrilevante");
        underTest.save(u);


        //when
        boolean expected=underTest.existsByNomeCompleto(nomeCurioso);

        //then
        assertThat(expected).isTrue();

    }

}