package playerMultimediale;

public class Immagine extends Elemento implements GestioneLuminosita {


	
	private int luminosita;
	
	
	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}

	@Override
	public void aumentaLuminosita() {
		luminosita++;
		System.out.println("Aumento luminosita. Luminosita: "+luminosita);
	}

	@Override
	public void diminuisciLuminosita() {
		luminosita--;
		System.out.println("Abbasso luminosita. Luminosita: "+luminosita);
	}
	
	public void show() {
		String out = titolo + EsecuzioneElemento.segnalaLuminosita(luminosita);
		System.out.println(out);
	}

	public int getLuminosita() {
		return luminosita;
	}

	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}

}
