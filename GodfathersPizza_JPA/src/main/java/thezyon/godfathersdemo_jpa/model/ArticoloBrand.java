package thezyon.godfathersdemo_jpa.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thezyon.godfathersdemo_jpa.model.Prodotto;
@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ArticoloBrand extends Prodotto {
	
	
	public ArticoloBrand(String nome, double prezzo) {
		super(nome, prezzo);
	}
	
	public String menuArticoloBrand() {
		return this.getNome() +" Prezzo: " + this.getPrezzo();
	}

}
