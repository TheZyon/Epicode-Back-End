package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;

@Entity
public class PizzaHawaiian extends Pizza {
	
	public PizzaHawaiian() {
		super.nome = "Pizza Hawaiian (Tomato, Cheese, Ham, Pinapple)";
		super.prezzo = 6.49;
		super.calorie = 1024d;
		
	}

}
