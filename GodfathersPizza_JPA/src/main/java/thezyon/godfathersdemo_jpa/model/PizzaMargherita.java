package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaMargherita extends Pizza {

	public PizzaMargherita() {
		super.nome = "Pizza Margherita (Tomato, Cheese)";
		super.prezzo = 4.99;
		super.calorie = 1104d;
		
	}

}
