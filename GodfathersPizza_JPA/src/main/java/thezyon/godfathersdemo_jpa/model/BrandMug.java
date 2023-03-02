package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import thezyon.godfathersdemo_jpa.model.ArticoloBrand;
@Entity
public class BrandMug extends ArticoloBrand {
	
	public BrandMug() {
		super.nome = "Mug";
		super.prezzo = 4.99;
	}

}
