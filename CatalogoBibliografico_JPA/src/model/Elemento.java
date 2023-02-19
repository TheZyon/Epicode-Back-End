package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "elemento")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name="getByTitolo", query = "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo")
@NamedQuery(name = "getByAnnoPubblicazione", query = "SELECT e FROM Elemento e WHERE e.anno_pubblicazione = :anno")
public class Elemento {

	/*
	 * codice_ISBN SERIAL PRIMARY KEY,
	titolo VARCHAR NOT NULL,
	anno_pubblicazione int NOT NULL,
	numero_pagine int NOT NULL,
	
	--fields libro
	autore VARCHAR NOT NULL,
	genere VARCHAR NOT NULL,
	
	--fields rivista 
	periodicita periodicita
	  */	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice_ISBN; 
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private int anno_pubblicazione;
	
	@Column(nullable = false)
	private int numero_pagine;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "elemento")
	private List<Prestito> prestiti;
	
	//metodo per aggiungere prestiti
	public void add(Prestito p) {
		if(prestiti==null) prestiti=new ArrayList<Prestito>();
		prestiti.add(p);
	}
	
	//constructors
	public Elemento() {}

	public Elemento(String titolo, int anno_pubblicazione, int numero_pagine) {
		super();
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione;
		this.numero_pagine = numero_pagine;
	}

	//getters&setters
	public int getCodice_ISBN() {
		return codice_ISBN;
	}

	public void setCodice_ISBN(int codice_ISBN) {
		this.codice_ISBN = codice_ISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}

	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}

	public int getNumero_pagine() {
		return numero_pagine;
	}

	public void setNumero_pagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Elemento [codice_ISBN=");
		builder.append(codice_ISBN);
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", anno_pubblicazione=");
		builder.append(anno_pubblicazione);
		builder.append(", numero_pagine=");
		builder.append(numero_pagine);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
