package playerMultimediale;

public class Audio extends ElementoRiproducibile implements GestioneVolume{

	
	private int volume;
	
	public Audio(String titolo, int durata, int volume) {
		super(titolo, durata);
		this.volume = volume;
	}

	public Audio(String titolo, int durata) {
		super(titolo, durata);
		this.volume = 1;
	}

	@Override
	public void play() {
		
    String out= EsecuzioneElemento.segnalaDurata(durata, titolo)+
    		EsecuzioneElemento.segnalaVolume( volume);
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

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	
	
}