package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import utils.DateUtil;

@Entity
@Table(name="prestito")

//named queries per prestiti dato utente o dato elemento
@NamedQuery(name="prestitiPerUtente", query = "SELECT p FROM Prestito p WHERE p.utente = :numero_tessera")
@NamedQuery(name="prestitiPerElemento", query="SELECT p FROM Prestito p WHERE p.elemento = :codice_ISBM")
public class Prestito {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_elemento_prestato")
	private Elemento elemento;
	
	@Column
	private Date data_inizio_prestito;
	@Column
	private Date data_restituzione_prevista;
	@Column
	private Date data_restituzione_effettiva;

	//constructors
	public Prestito(){}
	public Prestito(Utente utente, Elemento elemento, Date data_inizio_prestito,
			Date data_restituzione_effettiva) {
		super();
		this.utente = utente;
		this.elemento = elemento;
		this.data_inizio_prestito = data_inizio_prestito;
		this.data_restituzione_prevista = DateUtil.addDays( data_inizio_prestito, 30);
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}
	public Prestito(Utente utente, Elemento elemento, Date data_inizio_prestito) {
		super();
		this.utente = utente;
		this.elemento = elemento;
		this.data_inizio_prestito = data_inizio_prestito;
		this.data_restituzione_prevista = DateUtil.addDays( data_inizio_prestito, 30);
	}
	
	
	
	//getters&setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public Date getData_inizio_prestito() {
		return data_inizio_prestito;
	}
	public void setData_inizio_prestito(Date data_inizio_prestito) {
		this.data_inizio_prestito = data_inizio_prestito;
	}
	public Date getData_restituzione_prevista() {
		return data_restituzione_prevista;
	}
	public void setData_restituzione_prevista(Date data_restituzione_prevista) {
		this.data_restituzione_prevista = data_restituzione_prevista;
	}
	public Date getData_restituzione_effettiva() {
		return data_restituzione_effettiva;
	}
	public void setData_restituzione_effettiva(Date data_restituzione_effettiva) {
		this.data_restituzione_effettiva = data_restituzione_effettiva;
	}
	
	
	
	
	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Prestito [id=");
		builder.append(id);
		builder.append(", utente=");
		builder.append(utente.getNumero_tessera());
		builder.append(", elemento=");
		builder.append(elemento.getCodice_ISBN());
		builder.append(", data_inizio_prestito=");
		builder.append(data_inizio_prestito);
		builder.append(", data_restituzione_prevista=");
		builder.append(data_restituzione_prevista);
		builder.append(", data_restituzione_effettiva=");
		builder.append(data_restituzione_effettiva);
		builder.append("]");
		return builder.toString();
	}
	
}
