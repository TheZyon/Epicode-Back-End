package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.Prenotazione;
import com.SpringBoot_SpringSecurity.service.PrenotazioneService;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Stream;

@Component
public class PrenotazioneRunner implements ApplicationRunner {


    @Autowired private PrenotazioneService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        service.mastroLindo();
//        prenotazioniDefault();
    }

    public void prenotazioniDefault(){ //crea delle prenotazioni di default

        List<Triple<Long,Long,Timestamp>> p= Stream.of(
                Triple.of(4l,19l,Timestamp.valueOf("1995-04-09 12:00:00")),
                Triple.of(4l,26l,Timestamp.valueOf("1995-04-09 12:00:00")),
                Triple.of(5l,27l, Timestamp.valueOf("1995-04-09 12:00:00")),
                Triple.of(8l,28l,Timestamp.valueOf("1995-04-09 12:00:00")),
                Triple.of(8l, 29l,Timestamp.valueOf("1995-04-09 12:00:00"))

        ).toList();

        service.customCreate(p);


    }


}
