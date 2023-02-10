package catalogo;

public class Libro extends Articolo {

	String autore;
	String genere;
	public Libro(String IBSN, String titolo, String annoPubblicazione, String numeroPagine, String autore,
			String genere) {
		super(IBSN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public Libro() {
		autore="PinaPostina";
		genere="Fantasy";
	}
	public String getAutore() {
		return autore;
	}
	public String getGenere() {
		return genere;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("L@");
		builder.append(super.toString());
		
		builder.append(autore+"@");
	
		builder.append(genere+"#");
		
		return builder.toString();
	}

	public static Libro fromString(String s) throws Exception {//riceve una stringa del formato X@campo1@campo2@...@campoN
		String[] parts=s.split("@");
		if(parts.length!=7) throw new Exception("formato stringa sbagliato");
		else return new Libro(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
	}
	
	
}
