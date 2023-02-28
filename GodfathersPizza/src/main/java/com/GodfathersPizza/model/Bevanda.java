package com.GodfathersPizza.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	
	public String getMenuDrink() {
		return this.getNome() +" - Calorie: " + this.getCalorie() + " Prezzo: " + this.getPrezzo();
	}
	
}
