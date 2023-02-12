package Esercizi;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Customer;
import entities.Negozio;
import entities.NoSuchProductsException;
import entities.Order;
import entities.Product;

public class Operazioni {
	static Negozio negozio = new Negozio();

	static Logger log = LoggerFactory.getLogger(Operazioni.class);

	public static void main(String[] args) {

		/*
		 * prima di fare le operazioni richieste dall'esercizio, popolo l'inventario
		 * 
		 * 
		 */

		// creo dei clienti
		negozio.createClienti(
				Stream.of(new Customer("Carmelino", 2), new Customer("Mariello", 3), new Customer("AldoPrando", 1))
						.collect(Collectors.toList()));

		// creo dei prodotti
		negozio.addProducts(Stream
				.of(	new Product("Il signore dei piselli", "books", 10),
						new Product("Libro costoso", "books", 102),
						new Product("Biografia di Mariello", "books", 150), 
						new Product("sonaglino", "baby", 5),
						new Product("ciuccetto", "baby", 5), 
						new Product("pannolino", "baby", 6),
						new Product("coltello", "boys", 15),
						new Product("granata", "boys", 10)
						)
				.collect(Collectors.toList()));

		List<Product> babyProducts = negozio.getInventario().stream().filter(i -> i.getCategory() == "baby")
				.collect(Collectors.toList());

		// creo un oprdine contenente un prodotto di tipo "baby"
		try {
			negozio.createOrder(new Order("executed", LocalDate.parse("2021-03-01"),
					Stream.of(babyProducts.get(0), getRndProd()).collect(Collectors.toList()),
					negozio.getClienti().get(0)));
		} catch (NullPointerException e) {
			log.error(e.getMessage());

		} catch (NoSuchProductsException e) {
			log.error(e.getMessage());

		}

//		1. Lista prodotti disponibili della categoia books con prezzo >100
		var list1 = negozio.getInventario().stream()
				.filter(pr -> (pr.getCategory().equals("books") && pr.getPrice() > 100)).collect(Collectors.toList());

//		list1.forEach(b -> log.info(b.getName()));

//		2. Lista ordini di prodotti categoria baby 

		List<Order> listOrdersBaby = negozio.getOrdini().stream().filter(o -> {//filtriamo sugli ordini che hanno almeno un prodotto di tipo "baby"
			var oBabyProductsStream = o.getProducts().stream().filter(p -> p.getCategory() == "baby");
			return oBabyProductsStream.count() > 0;
		}).collect(Collectors.toList());

//		listOrdersBaby.forEach(o->log.info(o.getCustomer().getName()));
		
//		3. Applicae 10% sconto ai prodotti categoria boys

		List<Product> boysProducts=negozio.getInventario().stream()
				.filter(p->p.getCategory()=="boys")
				.collect(Collectors.toList());
		
		
//		boysProducts.forEach(p->log.info(""+p.getPrice()));
//		boysProducts.forEach(p->p.setPrice(p.getPrice()*0.9)); //applico sconto 10%
//		log.info("");
//		
//		negozio.getInventario().stream()
//		.filter(p->p.getCategory()=="boys")
//		.collect(Collectors.toList()).forEach(p->log.info(""+p.getPrice()));
		
		
//		4. Lista prodotti ordinati da clienti di tier 2 tra 01-Feb-2021 e 01-Apr-2021

		LocalDate firstDate= LocalDate.parse("2021-02-01");
		LocalDate secondDate= LocalDate.parse("2021-04-01");
		
		List<Order> l2=negozio.getOrdini().stream()
		.filter(o->o.getCustomer().getTier()==2) //ordini fatti da clienti di tier 2
		.filter(o->{ 							 //ordini fatti tra le due date
			var date= o.getOrderDate();
			var cond1= date.compareTo(firstDate)>=0;
			var cond2= date.compareTo(secondDate)<=0;
			if(cond1&&cond2) return true;
			else return false;
			})
		.collect(Collectors.toList());
		
		l2.forEach(o->log.info(o.getCustomer().getName()));
		
	}

	static Product getRndProd() { // gives a random item of the shop
		return negozio.getInventario().get((int) (Math.round(Math.random() * (negozio.getInventario().size() - 1)))); // prodotto
																														// casuale
																														// dell'inventario
	}
}
