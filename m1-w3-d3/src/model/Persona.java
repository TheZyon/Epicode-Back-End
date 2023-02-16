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
@Table(name="persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	private Date data_nascita;
	
	@Column
	private String sesso;
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			mappedBy = "persona")
	private List<Partecipazione> partecipazioni;
	
	//method to add to the list
		public void addPartecipazione(Partecipazione p) {
		if(partecipazioni==null) partecipazioni=new ArrayList<Partecipazione>();
		partecipazioni.add(p);
	}

		//constructors
	public Persona() {
		super();
	}

	public Persona(String nome, String cognome, String email, Date data_nascita, String sesso) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.data_nascita = data_nascita;
		this.sesso = sesso;
	}

	//getters&setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(List<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	
	//toString()
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cognome=");
		builder.append(cognome);
		builder.append(", email=");
		builder.append(email);
		builder.append(", data_nascita=");
		builder.append(data_nascita);
		builder.append(", sesso=");
		builder.append(sesso);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
