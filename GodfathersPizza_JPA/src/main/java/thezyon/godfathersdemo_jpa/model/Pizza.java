package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
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
public class Pizza extends Prodotto {
	
	double calorie;
	
	public Pizza(String nome, double prezzo, double calorie) {
		super(nome, prezzo);
		this.calorie = calorie;
	}

	public String menuPizza() {
		return this.getNome() +" - Calorie: " + this.getCalorie() + " Prezzo: " + this.getPrezzo();
	}
}
