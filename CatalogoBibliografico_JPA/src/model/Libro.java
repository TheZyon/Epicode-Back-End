package model;

import javax.persistence.Entity;



@Entity
public class Libro extends Elemento {

	
	
	private String autore;
	private String genere;
	
	//constructors
	public Libro() {}

	public Libro(String titolo, int anno_pubblicazione, int numero_pagine, String autore, String genere) {
		super( titolo, anno_pubblicazione, numero_pagine);
		this.autore = autore;
		this.genere = genere;
	}

	//getters&setters
	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	//toString()
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [autore=");
		builder.append(autore);
		builder.append(", genere=");
		builder.append(genere);
		builder.append("]");
		return super.toString()+builder.toString();
	}
	
	
	
	
	
	
}
