package playerMultimediale;

public class EsecuzioneElemento {

	
	public static String segnalaDurata(int durata, String titolo) {
		String out="";
		for(int i =0; i<durata; i++) {
			out+=titolo+ " ";
		}
		return out;
	}
	
	public static String segnalaVolume( int volume) {
		String out="";
		
		for(int i=0; i<volume; i++) {
			out+="!";
		}
		return out;
	}
	public static String segnalaLuminosita(int luminosita) {
		String out = "";
		for(int i=0; i<luminosita; i++) {
			out+="*";
		}
		return out;
	}
	
	
}
