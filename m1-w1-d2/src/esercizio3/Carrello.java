package esercizio3;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	private long idCustomer;
	private List<Articolo> articoli= new ArrayList<Articolo>();
	

	
	public Carrello(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public void createArticolo(Articolo a){
		articoli.add(a);
	}
	public List<Articolo> getArticoli() {
		return articoli;
	}
	public void deleteArticoloById(long id) {
		
		
		int index=-1; //l'indice nella lista dell'articolo di cui viene fornito l'id
		
		for(Articolo art:articoli) {
			if(art.getCodiceArticolo()==id) {
				index= articoli.indexOf(art);
			}
		}
	
		if(index>0) {
			articoli.remove(index);
		}else {System.out.println("Errore: indice non trovato");}
				
	}

	public long getIdCustomer() {
		return idCustomer;
	}
}
