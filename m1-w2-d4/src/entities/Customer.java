package entities;

public class Customer {

	
	private static long idCounter=0;
	private long id;
	private String name;
	private Integer tier;
	public Customer( String name, Integer tier) {
		this.id = idCounter++;
		this.name = name;
		this.tier = tier;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	
	
	
}
