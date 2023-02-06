package esercizio2;

import java.util.Scanner;

public class Main2 {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.println("Inserisci km:");
		double km=scanDouble();
		System.out.println("\n");
		System.out.println("Inserisci litri:");
		double lt= scanDouble();
		System.out.println("\n");
		try {
			
		System.out.println("result is: "+division(km, lt));
		
		}
		catch(DividedByZeroExceptionGiorgia e) { //exception che si verifica se il risultato è Infinite
			System.out.println("Giorgia found an exception!!");
			e.printStackTrace();
		}
		
	}

	public static double scanDouble() throws NumberFormatException{
		return Double.parseDouble(sc.nextLine());
	}
	public static double division(double a , double b) throws DividedByZeroExceptionGiorgia{
		double res = a/b; 
		
		if(res==a/0) {throw new DividedByZeroExceptionGiorgia();}
		
		return a/b;
		
	}
}
