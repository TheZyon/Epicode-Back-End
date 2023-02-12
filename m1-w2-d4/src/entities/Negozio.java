package entities;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Negozio {

	
	static Logger log= LoggerFactory.getLogger(Negozio.class);
	
	//inventario dei prodotti disponibili
	
	private List<Product> inventario=new ArrayList<Product>();

	private List<Customer> clienti=new ArrayList<Customer>();
	
	private List<Order> ordini= new ArrayList<Order>();
	
	
	public Negozio() {}
	public Negozio(List<Product> lista) {
		this.inventario = lista;
	}

	public List<Product> getInventario() {
		return inventario;
	}

	public List<Customer> getClienti() {
		return clienti;
	}

	public List<Order> getOrdini() {
		return ordini;
	}
	
	
	
	//metodi per gestire clienti e ordini
	
	public void createCliente(Customer c) {
		
		if(!(c==null||clienti.contains(c)))clienti.add(c);
		else log.error("cliente"+ c.getName()+ "è null o esiste già");
	
	}
	

	public void createClienti (List<Customer> list){
		
		list.forEach(c->createCliente(c));
	}
	
	
	
	public void createOrder(Order o) throws NullPointerException, NoSuchProductsException{
			
		
		if(inventario.containsAll(o.getProducts())) {
			ordini.add(o);//aggiungo ordine a lista ordini
			inventario.removeAll(o.getProducts()); //rimuovo i prodotti dell'ordine dall'inventario
			if(!clienti.contains(o.getCustomer())) createCliente(o.getCustomer());; //se chi ha fatto ordine non è cliente, lo aggiungiamo ai clienti
		}
		else throw new NoSuchProductsException("Non tutti i prodotti sono nell'inventario!");	
	}
	
	public void addItem(Product p) {
		if(p!=null) inventario.add(p);
		else log.error("product is null!");
		
	}
	
	public void addProducts(List<Product>l) {
		l.forEach(p->addItem(p));
	}
	
	
	
}
