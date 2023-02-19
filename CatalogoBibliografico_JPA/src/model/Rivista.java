package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;

@Entity
public class Rivista extends Elemento {
	
	@Enumerated(EnumType.STRING) //tecnique for mapping the enum to a string 
	@Type(type = "utils.EnumTypePostgreSql")
	private Periodicita periodicita;
	
	//constructors
	public Rivista() {}
	

	public Rivista(String titolo, int anno_pubblicazione, int numero_pagine,Periodicita periodicita) {
		super(titolo, anno_pubblicazione, numero_pagine);
		this.periodicita=periodicita;
	}
	//getters&setters

		public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}


	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rivista [periodicita=");
		builder.append(periodicita);
		builder.append("]");
		return super.toString()+builder.toString();
	}
	
	
	
}
