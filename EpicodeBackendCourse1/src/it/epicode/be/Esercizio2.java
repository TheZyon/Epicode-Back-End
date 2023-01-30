package it.epicode.be;


import java.util.Arrays;

public class Esercizio2 {

	public static void main(String[] args) {
//	
//		System.out.println("il primo programmino in Java...");
//	
//		
//		//moltiplication 
//		
//		System.out.println("inselisce due numeli e li moltiplico, io blavo...");
//		
//		Scanner sc= new Scanner(System.in);
//		int a= sc.nextInt();
//		int b= sc.nextInt();
//		
//		System.out.println("lisultato: " + String.valueOf(moltiplica(a,b)));
//	 
		
		//concat 
		 System.out.println();
		 System.out.println("concatenati: "+ concatena("Mariello ",33));
		 System.out.println();
		 
		//inserimento
		 
		 String[] sArray= {"Quando", "c'era", "si programmava con le", "porte", "aperte"};
		 sArray=inserisciInArray(sArray, "LVI");
		 Arrays.asList(sArray).forEach(str->{System.out.println(str);});
		 System.out.println();
		
		
	}
	
	
	public static int moltiplica(int a, int b) {
		return a*b;
	}

	public static String concatena(String s, int i) {
		return s.concat(String.valueOf(i));
	}
	
	public static String[] inserisciInArray(String[] s, String t) {
	String [] sNew= new String[6];
	
	for(int i=0; i<6; i++) {
		if(i<2) sNew[i]=s[i];
		if(i==2) sNew[i]=t;
		if(i>2) sNew[i]=s[i-1];
	}
	return sNew;
		
	}
	

}
