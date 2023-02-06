package esercizio1;

import java.util.Scanner;

public class Main {

	//creare una propria eccezione se vengono inseriti numeri negativi
	
	
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		RndArray array = new RndArray();

		boolean next = true;
		
		while(next) {
		System.out.println("Inserisci:\n•0->terminare;\n•1->stampa array;\n•2->modifica un elemento dell'array");
		int i; 
		try {i= scannInt(); 
		switch(i) {
		case 1: array.stampaArray(); break;
		case 2: 
			System.out.println("inserisci intero posizione"); 
			int j=scannInt(); 
			System.out.println("inserisci nuovo valore"); 
			int k = scannInt();
			array.setElementByIndex(j, k);
			break;
		case 0: next=false; break;
		default: System.out.println("numero errato");
		}
		
		
		}
		catch(NumberFormatException e){System.out.println("\nformato input sbagliato, riprova!\n");}
		catch(ArrayIndexOutOfBoundsException e) {System.out.println("\nLa posizione che hai specificato non esiste nell'array, riprova!\n");}
		}
	}
	public static int scannInt() throws NumberFormatException {

		return Integer.parseInt(sc.nextLine());
	}

}
