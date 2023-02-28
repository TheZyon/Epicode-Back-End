package com.GodfathersPizza.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Menu {
	
	private List<Pizza> menuPizza = new ArrayList<Pizza>();
	private List<Bevanda> menuDrink = new ArrayList<Bevanda>();
	private List<PizzaTopping> menuTopping = new ArrayList<PizzaTopping>();
	private List<ArticoloBrand> menuBrand = new ArrayList<ArticoloBrand>();

}
