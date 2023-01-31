package esercizio3;

import java.util.Date;

public class Cliente {
    static long id=0; 
	
	private long idCustomer;
	private String name; 
	private String lastName; 
	private String email;
	private Date subscriptionDate;
	private Carrello carrello= new Carrello(idCustomer);
	public Cliente(String name, String lastName, String email, Date subscriptionDate) {
		this.idCustomer=id;
		id++;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.subscriptionDate = subscriptionDate;
	}
	public static long getId() {
		return id;
	}
	public static void setId(long id) {
		Cliente.id = id;
	}
	public long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public Carrello getCarrello() {
		return carrello;
	}
	
	
	
	
}
