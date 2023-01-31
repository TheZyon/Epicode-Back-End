package it.epicode.be;

import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Benvenut*, dammi le tue misure: ");
		
		System.out.println("inserisci base e altezza per perimetro rettangolo: ");
		
		double base= sc.nextDouble();
		double altezza= sc.nextDouble();
		
		System.out.println("eccolo: "+ perimeter(base, altezza));
		
		System.out.println();
		
		System.out.println("inselisce numelo e vedo se pali: ");
		
		
		if(pariDispari(sc.nextInt())==0)System.out.println("pali");
		else {System.out.println("dispali");}
		
		
		System.out.println();
		
		System.out.println("inselisce lati tliangolo e io dice plezzo tliangolo, io blava:");
		
		System.out.println(perimetroTriangolo(sc.nextDouble(),sc.nextDouble(),sc.nextDouble()));
		
	}

	
	public static double perimeter(double a, double b) {
		return 2*(a+b);
	}
	
	public static int pariDispari(int i) {
		return i%2;
	}
	
	public static double perimetroTriangolo(double a, double b, double c) {
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
}
