package playerMultimediale;

public class Video extends ElementoRiproducibile implements GestioneVolume, GestioneLuminosita{



	private int volume; 
	private int luminosita;
	
	
	
	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo, durata);
		this.volume = volume;
		this.luminosita = luminosita;
	}

	
	public Video(String titolo, int durata, int luminosita) {
		super(titolo, durata);
		this.luminosita = luminosita;
		this.volume= 1;
	}


	@Override
	public void play() {
		String out = EsecuzioneElemento.segnalaDurata(durata, titolo)+
	    		EsecuzioneElemento.segnalaVolume(volume)+
	    		EsecuzioneElemento.segnalaLuminosita(luminosita);
		System.out.println(out);
	}

	@Override
	public void alzaVolume() {
		volume++;
		System.out.println("Alzo volume. Volume: "+volume);
	}

	@Override
	public void abbassaVolume() {
		volume--;
		System.out.println("Abbasso volume. Volume: "+volume);
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


	public int getVolume() {
		return volume;
	}


	public void setVolume(int volume) {
		this.volume = volume;
	}


	public int getLuminosita() {
		return luminosita;
	}


	public void setLuminosita(int luminosita) {
		this.luminosita = luminosita;
	}

	
	
}
