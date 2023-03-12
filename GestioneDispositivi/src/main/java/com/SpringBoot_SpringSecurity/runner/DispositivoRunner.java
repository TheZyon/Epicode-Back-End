package com.SpringBoot_SpringSecurity.runner;

import com.SpringBoot_SpringSecurity.entity.Dispositivo;
import com.SpringBoot_SpringSecurity.entity.Stato;
import com.SpringBoot_SpringSecurity.repository.DispositivoRepository;
import com.SpringBoot_SpringSecurity.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class DispositivoRunner implements ApplicationRunner {

    @Autowired private DispositivoService service;


    @Override
    public void run(ApplicationArguments args) throws Exception {

//        generaDispositivi();

//        service.getDispositiviDisponibili().forEach(dispositivo -> System.out.println(dispositivo.getStato().name()));
    }

    public void generaDispositivi() {

        List<Dispositivo> dispositiviDefault= Stream.of(
                new Dispositivo("auto aziendale scassata", Stato.DISPONIBILE),
                new Dispositivo("auto aziendale scassata", Stato.DISPONIBILE),
                new Dispositivo("auto aziendale scassata", Stato.IN_MANUTENZIONE),
                new Dispositivo("auto aziendale scassata", Stato.DISMESSO),
                new Dispositivo("sex toy professionale", Stato.DISMESSO),
                new Dispositivo("sciarpetta logo azienda", Stato.DISPONIBILE),
                new Dispositivo("Mac", Stato.DISPONIBILE),
                new Dispositivo("Mac", Stato.DISPONIBILE),
                new Dispositivo("Mac", Stato.DISPONIBILE),
                new Dispositivo("Mac", Stato.DISPONIBILE),
                new Dispositivo("Windows", Stato.DISPONIBILE),
                new Dispositivo("Windows", Stato.DISPONIBILE),
                new Dispositivo("Occhiali da sole per avere più carisma e fantomatico mistero", Stato.DISPONIBILE),
                new Dispositivo("Penna stilografica firme importanti azienda", Stato.IN_MANUTENZIONE),
                new Dispositivo("Foto Gavioli propiziatoria", Stato.IN_MANUTENZIONE),
                new Dispositivo("badge aziendale", Stato.DISPONIBILE),
                new Dispositivo("badge aziendale", Stato.DISPONIBILE),
                new Dispositivo("badge aziendale", Stato.DISPONIBILE)
        ).toList();

        service.createFromList(dispositiviDefault);

    }

}
