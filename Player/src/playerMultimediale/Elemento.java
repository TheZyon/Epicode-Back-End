package playerMultimediale;

public abstract class Elemento {
protected String titolo;

public Elemento(String titolo) {
	this.titolo = titolo;
	
}

public String getTitolo() {
	return titolo;
}

public void setTitolo(String titolo) {
	this.titolo = titolo;
}


}
