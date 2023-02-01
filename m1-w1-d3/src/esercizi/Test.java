package esercizi;

import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

//		es 1
//		stringaPariDispari("Carmelo");
//		annoBisestile(2023);
		
//		es2
//		es2(2);
//		es2(50);
		
//		es3();
//		es4();
	
	}

	public static boolean stringaPariDispari(String str) {
		int parita= str.length()%2;
		boolean res;
	    if(parita==0) {res=true;} else {res=false;}
	    return res;
	}
	
	public static boolean annoBisestile(int anno) {
		if(anno%4==0 || (anno%100==0 && anno%400==0)) {
			return true;
		}else { return false;}
	}
	
	
	public static void es2(int i){
		switch(i) {
		case 0,1,2: System.out.println("l'intero è: "+Integer.toString(i));
		default: System.out.println("errore: numero troppo grande!");}
	}
	
	
	public static void es3() {
		
		Scanner sc= new Scanner(System.in);
		boolean continuee=true;
		
		while(continuee) {
			System.out.println("scrivi una stringa da suddividere");
			System.out.println();
			System.out.println("Eccola suddivisa: "+ suddividi(sc.nextLine()));
			System.out.println();
			System.out.println("Scrivi :q per terminare, altrimenti un carattere qualunque");
			if(sc.nextLine().equals(":q"))continuee=!continuee;
			
		}
		
		System.out.println("Finish");
		
	}
	public static String suddividi(String s) {
		//ritorna una stringa ottenuta suddividendo i caratteri della stringa
		//in input con una virgola
		String res="";
		
		StringCharacterIterator si= new StringCharacterIterator(s);
		
		for(int i=0; si.getIndex()<s.length(); si.next()) {
			if(si.getIndex()<s.length()-1) res+=si.current() + ",";
			 else res+=si.current();
		}
		return res;
		
	}
	
	public static void es4() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Inserisci un numero per avere stampato il conto alla rovescia"+
							"grazie ai nostri potenti mezzi");
		String line= sc.nextLine();
		
		
		int index=0; //numero per verifica che tutti i caratteri siano cifre
		for(char c :line.toCharArray()) if(Character.isDigit(c)) index++;
		
		if(index==line.length()) {
			System.out.println("Faccio conto alla rovescia: ");
			int n= Integer.parseInt(line);
			for(int i=n; i>-1;i--) {System.out.println(i);}
		}
		else {System.out.println("Scrivi un numero a modo!");}
		
	}
	
}
