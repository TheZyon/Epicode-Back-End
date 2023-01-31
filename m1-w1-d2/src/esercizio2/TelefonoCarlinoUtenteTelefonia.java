package esercizio2;

import java.util.ArrayList;
import java.util.List;

public class TelefonoCarlinoUtenteTelefonia {

	public static void main(String[] args) {
	
		
		List <Chiamata> chiamate = new ArrayList<Chiamata>();
		
		chiamate.add(new Chiamata(10, 3332244, 0.50));
		chiamate.add(new ChiamataCostosaTipoNipoteMubarak(10, 333698111));
		chiamate.add(new Chiamata(20, 118, 0));
		chiamate.add(new ChiamataCostosaTipoNipoteMubarak(10, 333698111));
		chiamate.add(new Chiamata(20, 118, 0));
	
		Sim wind = new Sim(23456456, chiamate);
		
		
		
		wind.ricarica(1000);
		
		wind.info();
		
		wind.chiama(new ChiamataCostosaTipoNipoteMubarak(10,333698111 ));
		
		wind.info();
		
	}

}
