package esercizio2;

public class Chiamata {

	double minuti;
	long numeroChiamato;
	double costoAlMinuto;
	public Chiamata(double minuti, long numeroChiamato, double costoAlMinuto) {
		super();
		this.minuti = minuti;
		this.numeroChiamato = numeroChiamato;
		this.costoAlMinuto = costoAlMinuto;
	}
	public double getMinuti() {
		return minuti;
	}
	public void setMinuti(double minuti) {
		this.minuti = minuti;
	}
	public long getNumeroChiamato() {
		return numeroChiamato;
	}
	public void setNumeroChiamato(long numeroChiamato) {
		this.numeroChiamato = numeroChiamato;
	}
	public double getCostoAlMinuto() {
		return costoAlMinuto;
	}
	public void setCostoAlMinuto(double costoAlMinuto) {
		this.costoAlMinuto = costoAlMinuto;
	}
	
	public double prezzo() { //ritorna il prezzo della chiamata
		return minuti*costoAlMinuto;
	}
	
	
}
