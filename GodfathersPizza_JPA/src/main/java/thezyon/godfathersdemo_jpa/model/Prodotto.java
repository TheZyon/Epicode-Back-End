package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="prodotto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
@Data

public abstract class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	String nome;
	@Column
	double prezzo;

	public Prodotto(String nome, double prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}
}
