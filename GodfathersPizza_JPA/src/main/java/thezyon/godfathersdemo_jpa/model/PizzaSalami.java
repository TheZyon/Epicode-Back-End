package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaSalami extends Pizza {
	
	public PizzaSalami() {
		super.nome = "Pizza Salami (Tomato, Cheese, salami)";
		super.prezzo = 5.99;
		super.calorie = 1160d;
		
	}

}
