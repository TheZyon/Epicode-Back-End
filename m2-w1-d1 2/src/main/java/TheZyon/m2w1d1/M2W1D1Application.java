package TheZyon.m2w1d1;

import articoli.franchise.MegaHentaiGiaEquipaggiato;
import articoli.franchise.SuperHentaiEquipaggiatoOltreSchemiUmanaComprensione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class M2W1D1Application {

	static Logger logger = LoggerFactory.getLogger(M2W1D1Application.class);
	static ApplicationContext ac = new AnnotationConfigApplicationContext(Configuration.class);
	public static void main(String[] args) {

		SpringApplication.run(M2W1D1Application.class, args);

		var bunny= ac.getBean(MegaHentaiGiaEquipaggiato.class);

		logger.info("the bunny costs: "+ bunny.getPrice());

	}






}
