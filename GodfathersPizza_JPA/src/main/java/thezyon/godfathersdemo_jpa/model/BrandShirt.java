package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import thezyon.godfathersdemo_jpa.model.ArticoloBrand;
@Entity
public class BrandShirt extends ArticoloBrand {
	
	public BrandShirt() {
		super.nome = "Shirt";
		super.prezzo = 21.99;
	}
}
