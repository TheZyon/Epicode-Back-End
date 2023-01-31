package esercizio3;

public class Articolo {

	private long codiceArticolo;
	private String descrizioneArticolo;
	private double prezzo;
	private int quantiInMagazzino;
	public Articolo(long codiceArticolo, String descrizioneArticolo, double prezzo, int quantiInMagazzino) {
		this.codiceArticolo = codiceArticolo;
		this.descrizioneArticolo = descrizioneArticolo;
		this.prezzo = prezzo;
		this.quantiInMagazzino = quantiInMagazzino;
	}
	public long getCodiceArticolo() {
		return codiceArticolo;
	}
	public void setCodiceArticolo(long codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}
	public String getDescrizioneArticolo() {
		return descrizioneArticolo;
	}
	public void setDescrizioneArticolo(String descrizioneArticolo) {
		this.descrizioneArticolo = descrizioneArticolo;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantiInMagazzino() {
		return quantiInMagazzino;
	}
	public void setQuantiInMagazzino(int quantiInMagazzino) {
		this.quantiInMagazzino = quantiInMagazzino;
	}
	
	
}
