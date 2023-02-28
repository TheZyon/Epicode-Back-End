package com.GodfathersPizza.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ArticoloBrand extends Prodotto {
	
	
	public ArticoloBrand(String nome, double prezzo) {
		super(nome, prezzo);
	}
	
	public String getMenuArticoloBrand() {
		return this.getNome() +" Prezzo: " + this.getPrezzo();
	}

}
