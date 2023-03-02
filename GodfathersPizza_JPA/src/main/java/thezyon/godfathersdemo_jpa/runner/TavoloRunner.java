package thezyon.godfathersdemo_jpa.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import thezyon.godfathersdemo_jpa.model.Tavolo;
import thezyon.godfathersdemo_jpa.service.TavoloService;
@Component
public class TavoloRunner implements ApplicationRunner {
    @Autowired TavoloService tavoloService;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        tavoloService.createTavolo(new Tavolo(5, true));

    }
}
