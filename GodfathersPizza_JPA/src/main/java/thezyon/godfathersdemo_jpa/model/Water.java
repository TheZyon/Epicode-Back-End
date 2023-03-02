package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;

@Entity

public class Water extends Bevanda {

	public Water() {
		super.nome = "Water (0.5l)";
		super.prezzo = 1.29;
		super.calorie = 0d;
	}
}
