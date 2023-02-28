package com.GodfathersPizza.model;

public class PizzaTopping extends Pizza {
	
	Pizza pizza;
	String nome;
	double calorie;
	double prezzo;
	
	public PizzaTopping(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getNome() {
		return this.pizza.getNome() + " + Topping: " + nome;
	}

	@Override
	public double getCalorie() {
		return this.pizza.getCalorie() + this.calorie;
	}


	@Override
	public double getPrezzo() {
		return this.pizza.getPrezzo() + this.prezzo;
	}
	
	public String getMenuTopping() {
		return this.nome +" - Calorie: " + this.calorie + " Prezzo: " + this.prezzo;
	}

}
