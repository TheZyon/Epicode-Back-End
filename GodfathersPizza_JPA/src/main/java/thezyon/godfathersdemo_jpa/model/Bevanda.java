package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thezyon.godfathersdemo_jpa.model.Prodotto;
@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Bevanda extends Prodotto {
	
	double calorie;

	public Bevanda(String nome, double prezzo, double calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}
	
	public String menuDrink() {
		return this.getNome() +" - Calorie: " + this.getCalorie() + " Prezzo: " + this.getPrezzo();
	}
	
}
