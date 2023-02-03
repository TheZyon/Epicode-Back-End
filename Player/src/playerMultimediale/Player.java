package playerMultimediale;

import java.util.Arrays;
import java.util.Scanner;

public class Player {

	public static void main(String[] args) {
		
		
		
		/**
		 * Features aggiuntive: 
		 * 0. classe ControllerElemento che permette all'utente di modificare volume/luminosità dell'elemento selezionato, o di eseguirlo
		 * 1. controlli sull'input dell'utente (vedi r.54 e metodo verificaInput() r.76)
		 * 2. classe EsecuzioneElemento che riduce il codice per i metodi play() e show() delle classi figlie di Elemento;
		 * 3. possibilità di sostituire un elemento salvato con un'altro elemento 
		 *  */

		
		
		//inserimento elementi
		int size=5;
		Elemento[] eArray= new Elemento[size];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("inserisci 5 elementi");
		for(int i = 0; i<size; i++) {
		
			Elemento e = riceviElemento(sc);
			
			if(e!=null) eArray[i]=e;
			else i--;
		
		}
		
		
		
		
		//gestione elementi
		
		int indiceRiproduzione=-1; 
		
		while(indiceRiproduzione!=0) {
			
			//messaggio iniziale
			System.out.println("\nI titoli sono: \n");
			for(Elemento e : eArray) {
				System.out.println((indexOf(eArray, e) +1)+ ". " + e.getTitolo() +"\n");
			}
			System.out.println("Allora, inserisci il numero dell'elemento multimediale da selezionare (1,2,3,4,5)");
			System.out.println("Digita 6 se vuoi modificare gli elementi salvati");
			System.out.println("Altrimenti digita un altro numero >=0 per terminare");
			
			indiceRiproduzione = verificaInput(sc);
			
			
			if(indiceRiproduzione==6) { //interfaccia per sostituire un elemento salvato
				System.out.println("\nInserisci l'indice dell'elemento da sostituire (1,2,3,4,5)\n");
				int index=verificaInput(sc)-1;
				Elemento e = riceviElemento(sc);
				eArray[index]=e;
			}
			else if(indiceRiproduzione<6 && indiceRiproduzione>0) { //interfaccia per interagire con un elemento salvato
			Elemento selected = eArray[indiceRiproduzione-1];
			
			ControllerElemento controller = new ControllerElemento(selected, sc);
			boolean dentro=true;
			while(dentro) {
			dentro=controller.mostraEdEseguiOpzioni();
			}
			}
			
			
		}
		
		System.out.println("\nIl coviddi non esiste, ora lo sai.\nTHE END.");
	}

	

	


	public static Elemento riceviElemento(Scanner sc) {
		//prova ad aggiungere un elemento con i dati forniti dall'utente all'array eArray 
		//ritorna true se aggiunta effettuata, false altrimenti
		System.out.println("Che tipo di elemento vuoi inserire? (AUDIO, VIDEO, IMMAGINE)");
		
		String titolo;
		int durata;
		int volume; 
		int luminosita;
		
		switch(sc.nextLine()) {
		
		case "AUDIO": 
			titolo= invitoInserireTitolo(sc);
			durata= invitoInserireDurata(sc);
			return new Audio(titolo, durata); 
			
			
		case "VIDEO":
			titolo= invitoInserireTitolo(sc);
			durata= invitoInserireDurata(sc);
			luminosita= invitoInserireLuminosita(sc);
			return new Video(titolo, durata, luminosita); 
			
			
		case "IMMAGINE": 
			 titolo= invitoInserireTitolo(sc);
			 luminosita= invitoInserireLuminosita(sc);
			 return new Immagine(titolo, luminosita);
			
		default: System.out.println("Errore, scegli uno dei tipi suggeriti"); return null;
		}
	}
	public static boolean isNumeric(String strNum) { 
		//verifica se una stringa può essere convertita in int
		if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Integer.parseInt(strNum);
	        if(d<0) return false; //vogliamo solo interi >=0
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    
	    return true;
	}
	public static int verificaInput(Scanner sc) { 
		//verifica se l'input contiene una stringa che può essere convertita in int, e se l'int è >=0
		//e restituisce l'int in caso corretto
		//altrimenti fa reinserire l'input
		
		String numStr="";
		
		boolean correctInput=false;//verifica sull'input utente
		
		while(!correctInput) {
			numStr=sc.nextLine();
			if(isNumeric(numStr)) {//verifica se la stringa immessa è del formato corretto
				correctInput=true;
			}
			else {System.out.println("hai scritto male, riprova");}
		}
		return Integer.parseInt(numStr);
	}

	public static String invitoInserireTitolo(Scanner sc) {
		System.out.println("Inserisci titolo");
		return sc.nextLine();
	}
	
	public static int invitoInserireDurata(Scanner sc) {
		System.out.println("Inserisci durata");
		return verificaInput(sc);
	}
	
	public static int invitoInserireLuminosita(Scanner sc) {
		System.out.println("Inserisci luminosita");
		return verificaInput(sc);
	}

	public static <T> int indexOf(T[] arr, T val) {
	    return Arrays.asList(arr).indexOf(val);
	}

}
