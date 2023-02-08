package Es3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main3 {

	static Logger log = LoggerFactory.getLogger(Main3.class);
	public static void main(String[] args) {
		
		List<Presenza> list = new ArrayList<Presenza>();

		list.add(new Presenza("Mariello Fantasmino"));
		list.add(new Presenza("Mr. Craig",10));
		list.add (new Presenza("Cavallo Cavalli", 100));
		
		var rp= new RegistroPresenze(list);
		
		rp.convertListToString();//creo stringa da scrivere nel file
		
		
		try {//scrivo il file
			rp.createPresenze();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		List<Presenza> presenzeDaFile= new ArrayList<Presenza>();
		
		try { //recupero lista presenze dal file
			presenzeDaFile=rp.convertStringToList(rp.readPresenze());
		} catch (IOException e) {
			
			log.error(e.getMessage());
		}
	
		System.out.println();
		log.info("Stampo lista recuperata");
		System.out.println();
		
		presenzeDaFile.forEach(p->log.info(p.getNome()));
		
	}

}
