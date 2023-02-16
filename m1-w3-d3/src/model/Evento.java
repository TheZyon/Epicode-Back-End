package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String titolo;
	
	@Column(nullable = false)
	private Date data_evento;
	
	@Column
	private String descrizione;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo_evento;
	
	@Column(nullable = false)
	private int numero_massimo_partecipanti;
	
	
	public Evento() {}
	public Evento(String titolo, Date data_evento, String descrizione, TipoEvento tipo_evento,
			int numero_massimo_partecipanti) {
		this.titolo = titolo;
		this.data_evento = data_evento;
		this.descrizione = descrizione;
		this.tipo_evento = tipo_evento;
		this.numero_massimo_partecipanti = numero_massimo_partecipanti;
	}

	
	
	public Evento(int id, String titolo, Date data_evento, String descrizione, TipoEvento tipo_evento,
			int numero_massimo_partecipanti) {
		
		this.id = id;
		this.titolo = titolo;
		this.data_evento = data_evento;
		this.descrizione = descrizione;
		this.tipo_evento = tipo_evento;
		this.numero_massimo_partecipanti = numero_massimo_partecipanti;
	}
	public Evento(Date data_evento, TipoEvento tipo_evento, int numero_massimo_partecipanti) {
		super();
		this.data_evento = data_evento;
		this.tipo_evento = tipo_evento;
		this.numero_massimo_partecipanti = numero_massimo_partecipanti;
	}
	
	//getters & setters	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Date getData_evento() {
		return data_evento;
	}
	public void setData_evento(Date data_evento) {
		this.data_evento = data_evento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoEvento getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(TipoEvento tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	public int getNumero_massimo_partecipanti() {
		return numero_massimo_partecipanti;
	}
	public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
		this.numero_massimo_partecipanti = numero_massimo_partecipanti;
	}
	
	
	//toString
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evento [id=");
		builder.append(id);
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", data_evento=");
		builder.append(data_evento);
		builder.append(", descrizione=");
		builder.append(descrizione);
		builder.append(", tipo_evento=");
		builder.append(tipo_evento);
		builder.append(", numero_massimo_partecipanti=");
		builder.append(numero_massimo_partecipanti);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	

	
	
}
