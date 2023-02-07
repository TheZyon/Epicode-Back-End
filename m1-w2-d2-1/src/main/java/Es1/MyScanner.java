package Es1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyScanner {

	//questa classe serve solo a non riscrivere lo stesso metodo in tutti i main
	
	private static final Scanner sc = new Scanner(System.in);
	
	
	public static String nextLine() {
		return sc.nextLine();
	}
	public static int scanInt() {
		int res=-1;
		try {
		   String s= sc.nextLine();
		   res=Integer.parseInt(s);
		   
		}
		catch(NoSuchElementException e){System.out.println("non hai scritto niente!");}
		catch(NumberFormatException e) {System.out.println("Number format exception!");}
		
		return res;
	}
	
	
}
