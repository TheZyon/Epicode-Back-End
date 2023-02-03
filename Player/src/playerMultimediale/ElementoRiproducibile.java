package playerMultimediale;

public abstract class ElementoRiproducibile extends Elemento {
protected int durata;





public ElementoRiproducibile(String titolo, int durata) {
	super(titolo);
	this.durata = durata;
}





abstract public void play();





public int getDurata() {
	return durata;
}





public void setDurata(int durata) {
	this.durata = durata;
}


}
