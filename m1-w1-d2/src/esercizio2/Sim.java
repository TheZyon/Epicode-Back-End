package esercizio2;

import java.util.List;

public class Sim {

	private long numeroTelefono;
	private double credito;
	List<Chiamata> chiamate;
	public Sim(long numeroTelefono, List<Chiamata> chiamate) {
	
		this.numeroTelefono = numeroTelefono;
		this.credito = 0;
		this.chiamate = chiamate;
	}
	
	//metodi
	public void info() {
		System.out.println("Numero Sim: "+numeroTelefono);
		System.out.println();
		System.out.println("Credito: "+credito);
		System.out.println();
		System.out.println("Lista ultime 5 chiamate: ");
		chiamate.forEach(c->{
			if(chiamate.size()-chiamate.indexOf(c)<6) 
			System.out.println(chiamate.indexOf(c)+ "." + "verso: "+ c.getNumeroChiamato()+"; durata: "+ c.getMinuti()+ " minuti;");
			
		});
	}

	
	
	public void ricarica(double seLiPrendeENonImportaChiLiMette) {
		credito+=seLiPrendeENonImportaChiLiMette;
	}
	public void chiama(Chiamata c) {
		chiamate.add(c);
		credito-=c.prezzo();
	}
	
}
