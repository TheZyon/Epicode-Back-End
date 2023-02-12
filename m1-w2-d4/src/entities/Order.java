package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private static long idCounter=0; 
	private long id;
	private String status;
	private LocalDate orderDate;
	private List<Product> products;
	private Customer customer;
	public Order( String status, LocalDate orderDate, List<Product> products, Customer customer) {
		this.id = idCounter++;
		this.status = status;
		this.orderDate = orderDate;
		this.products = products;
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
    
	
	
}
