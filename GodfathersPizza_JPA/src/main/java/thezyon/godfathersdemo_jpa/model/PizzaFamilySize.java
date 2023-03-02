package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class PizzaFamilySize extends Pizza {
	


	/*@Column(name = "")
	Pizza pizza;
	double calorie;
	double prezzo;
	
	
	public PizzaFamilySize(Pizza pizza) {
		super();
		this.pizza = pizza;
		this.calorie = 1.95;
		this.prezzo = 4.15;
	}

	public PizzaFamilySize() {

	}

	@Override
	public String getNome() {
		return this.pizza.getNome() + " - Family Size";
	}

	@Override
	public double getCalorie() {
		return this.pizza.getCalorie() * this.calorie;
	}


	@Override
	public double getPrezzo() {
		return this.pizza.getPrezzo() + this.prezzo;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getMenuPizza() {
		return "Family Size for Pizza - Calorie: " + this.calorie + " Prezzo: " + this.prezzo;
	}
	*/
}
