package it.epicode.be;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeTreStringhe {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("inselisce tle linee...");
		
		String[] s= new String[3];
		
		s[0]=sc.nextLine();
		s[1]=sc.nextLine();
		s[2]=sc.nextLine();
		String stringhetta="";
		
		for(String str:s) {
			stringhetta+=str + " ";
		}
		
		System.out.println(stringhetta);
	
		stringhetta="";
		
		System.out.println();
		
		
		List<String>list = Arrays.asList(s);
		Collections.reverse(list);
		for(String str:list) {
			stringhetta+=str+ " ";
		}
		
		
		System.out.println(stringhetta);
	
	}

	
	
	
	
	
}
