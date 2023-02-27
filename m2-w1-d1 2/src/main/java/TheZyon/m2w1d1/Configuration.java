package TheZyon.m2w1d1;

import articoli.franchise.*;
import articoli.pizze.Hamburger;
import articoli.pizze.PizzaMargherita;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
@ComponentScan("articoli")
public class Configuration {


    @Bean
    @Scope("prototype")
    public PizzaMargherita pizzaMargherita(){
        return new PizzaMargherita();

    }

    @Bean
    @Scope("prototype")
    public Hamburger hamburger(){
        return new Hamburger();
    }

    @Bean
    @Scope("singleton")
    public MegaHentaiGiaEquipaggiato megaHentaiGiaEquipaggiato(){
        return new MegaHentaiGiaEquipaggiato();
    }


    @Bean
    @Scope("singleton")
    public SuperHentaiEquipaggiatoOltreSchemiUmanaComprensione bunnyMan(){
        return new SuperHentaiEquipaggiatoOltreSchemiUmanaComprensione();
    }

    @Bean
    public SciarpettaElegante sciarpettaElegante(){
        return new SciarpettaElegante();
    }

    @Bean
    public PelucheOmoCunigghio pelucheOmoCunigghio(){
        return new PelucheOmoCunigghio();
    }

    @Bean
    public EquipaggiamentoTheyThem equipaggiamentoTheyThem(){
        return new EquipaggiamentoTheyThem();
    }
    @Bean
    public SpadaNellaRoccia spadaNellaRoccia(){
        return new SpadaNellaRoccia();
    }

    @Bean
    public StivalettiGiallini stivalettiGiallini(){
        return new StivalettiGiallini();
    }
}
