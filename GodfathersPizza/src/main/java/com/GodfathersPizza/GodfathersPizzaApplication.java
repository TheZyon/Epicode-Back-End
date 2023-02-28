package com.GodfathersPizza;

import com.GodfathersPizza.model.Ordine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GodfathersPizza.configuration.MenuConfiguration;
import com.GodfathersPizza.model.Menu;

@SpringBootApplication
public class GodfathersPizzaApplication {
	
	static Menu menu;
	static Ordine ordine;
	public static void main(String[] args) {
		SpringApplication.run(GodfathersPizzaApplication.class, args);
		gestioneMenu();
	}
	
	public static void gestioneMenu() {
		AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(MenuConfiguration.class);
	
		// Recupero Bean
		menu = (Menu) appCtx.getBean("menu");
		stampaMenu();
		ordine=(Ordine) appCtx.getBean("ordine");
		stampaOrdineConPrezzo();
		appCtx.close();
	}
	
	public static void stampaMenu() {
		System.out.println("********** Menu **********");
		System.out.println("Pizzas");
		menu.getMenuPizza().forEach(p -> System.out.println(p.getMenuPizza()));
		
		System.out.println("Toppings");
		menu.getMenuTopping().forEach(t -> System.out.println(t.getMenuTopping()));
		
		System.out.println("Drinks");
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuDrink()));
		
		System.out.println("Franchise");
		menu.getMenuBrand().forEach(a -> System.out.println(a.getMenuArticoloBrand()));
	}

	public static void stampaOrdineConPrezzo(){
		System.out.println("********** Ordine **********");
		ordine.getElementi().forEach(e->{

			System.out.println(e.getKey().getNome()+ "----" + e.getKey().getPrezzo()+ " nota cliente: " + e.getValue());
		});
		System.out.println("_____________");
		System.out.println("SODDI DA PAGARE");
		System.out.println("_____________");
		System.out.println(ordine.getImportoTotale());
	}


}
