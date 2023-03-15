package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.Personcina;
import com.SpringBoot_SpringSecurity.service.PersoncinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class PersoncinaRunner implements ApplicationRunner {

    @Autowired private PersoncinaService service;
    @Override
    public void run(ApplicationArguments args) throws Exception {

//        defaultPersoncine();
    }

    public void defaultPersoncine(){

        List<Personcina> personcine= Stream.of(

                new Personcina("Alberto", 33, true),
                new Personcina("Carmela", 44, true),
                new Personcina("coco", 3, false)

        ).toList();

        service.createAll(personcine);

    }



}
