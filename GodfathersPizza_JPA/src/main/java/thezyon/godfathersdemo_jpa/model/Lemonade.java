package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import thezyon.godfathersdemo_jpa.model.Bevanda;
@Entity
public class Lemonade extends Bevanda {

	public Lemonade() {
		super.nome = "Lemonade (0.33l)";
		super.prezzo = 1.29;
		super.calorie = 128d;
	}

}
