package com.piopio.bellini.esercizietti;

public class Tests {

	public static void main(String[] args) {

		Rettangolo rett1= new Rettangolo(10,10);
		Rettangolo rett2 = new Rettangolo(5,10);
		
		stampaInfoRettangolo(rett1);
		stampaInfoRettangoli(rett1,rett2);
	}

	public static void stampaInfoRettangolo(Rettangolo rett) {
		System.out.println("area: "+ rett.area());
		System.out.println("perimetro: "+rett.perimetro());
	}
	
	public static void stampaInfoRettangoli(Rettangolo rett1, Rettangolo rett2) {
		System.out.println("area 1: "+ rett1.area());
		System.out.println("perimetro 1: "+rett1.perimetro());
		System.out.println();
		System.out.println("area 2: "+ rett2.area());
		System.out.println("perimetro 2: "+rett2.perimetro());
		System.out.println("somma aree: "+ (rett1.area()+ rett2.area()));
		System.out.println("somma peni: "+ (rett1.perimetro()+rett2.perimetro()));
	}
}
