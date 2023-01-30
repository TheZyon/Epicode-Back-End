package corso_java;

import java.util.Scanner;

public class Lezione_1_Epicode {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Scrivi il tuo nome:");
			String name=sc.nextLine();

			System.out.println(name.toUpperCase());
		}
	
	}

}
