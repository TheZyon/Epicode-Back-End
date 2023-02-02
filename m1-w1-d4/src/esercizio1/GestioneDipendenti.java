package esercizio1;

import java.util.ArrayList;
import java.util.List;

import esercizio1.Dipendente.Dipartimento;
import esercizio1.Dipendente.Livello;

public class GestioneDipendenti {

	public static void main(String[] args) {
	
		List<Dipendente> servitu= new ArrayList<Dipendente>();
		
		Dipendente opraio1= new Dipendente("belloPompello123", Dipartimento.PRODUZIONE);
		Dipendente opraio2= new Dipendente("belloPompello456", Dipartimento.PRODUZIONE);
		Dipendente impiegato= new Dipendente("belloPompello678", 1200, 35, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente megaDirettore= new Dipendente("belloPompello1", 2000, 50, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		servitu.add(opraio1);
		servitu.add(opraio2);
		servitu.add(impiegato);
		servitu.add(megaDirettore);
		
		opraio1.promuovi();
		impiegato.promuovi();
		
		servitu.forEach(slave->{
			slave.stampaDatiDipendente(); 
			System.out.println();}
		);
		
		double tot=0; //conterrà la somma degli stipendi
		for(Dipendente slave : servitu) {
			tot+=CalcolatorePaghe.calcolaPaga(slave, 5);
		}
		
		System.out.println("-----------");
		
		System.out.println("Totale da bonificare dipendenti: "+ tot*0.4 +"€"); // gli stipendi effettivamente versati
		System.out.println("Budget per party figlia Elenella: "+ tot*0.6 +"€"); // questa è un'azienda familiare
		
		
		
	}

}
