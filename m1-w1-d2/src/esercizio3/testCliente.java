package esercizio3;

import java.util.Date;

public class testCliente {

	public static void main(String[] args) {
	
		
		Date d= new Date();
		
		Cliente mariello = new Cliente("Mariello", "Miriello", "mrCraig@gmail.com", d);

		mariello.getCarrello().createArticolo(new Articolo(222, "sciarpa bacino sexy aka pareo", 22, 10));
	
		mariello.getCarrello().createArticolo(new Articolo(666, "documento identità falso modello Ross Ubricht", 250, 1));
		
		mariello.getCarrello().createArticolo(new Articolo(777, "parrucca bionda di Candy Candy", 300, 3));
		
		//stampo le descrizioni degli articoli nel carrello di Mariello
		mariello.getCarrello().getArticoli().forEach(art->{System.out.println(art.getDescrizioneArticolo());});
	
		mariello.getCarrello().deleteArticoloById(666);
		
		System.out.println();
		
		mariello.getCarrello().getArticoli().forEach(art->{System.out.println(art.getDescrizioneArticolo());});
	
	}

}
