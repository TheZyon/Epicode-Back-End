package com.GodfathersPizza.model;

public class ToppingHam extends PizzaTopping {
	
	public ToppingHam(Pizza pizza) {
		super(pizza);
		nome = "Ham";
		calorie = 35d;
		prezzo = 0.99;
	}

}
