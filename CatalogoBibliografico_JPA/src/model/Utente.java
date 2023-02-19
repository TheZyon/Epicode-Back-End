package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="utente")

public class Utente {

	
	/*
 	numero_tessera SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL
*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero_tessera;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private Date data_nascita;

	
	//lista prestiti associata al mapping 1-* con Prestito
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
	private List<Prestito> prestiti;
	
	//metodo per aggiungere elementi a prestiti
	public void add(Prestito p) {
			if(prestiti==null) prestiti=new ArrayList<Prestito>();
			prestiti.add(p);
			
		}
	
	
	
	//constructors
	public Utente() {}

	public Utente(String nome, String cognome, Date data_nascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
	}

	
	//getters&setters
	public int getNumero_tessera() {
		return numero_tessera;
	}

	public void setNumero_tessera(int numero_tessera) {
		this.numero_tessera = numero_tessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	
	public List<Prestito> getPrestiti() {
		return prestiti;
	}



	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}



	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utente [numero_tessera=");
		builder.append(numero_tessera);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", data_nascita=");
		builder.append(data_nascita);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
