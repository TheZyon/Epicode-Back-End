package catalogo;

public abstract class Articolo { 
//superclasse con gli attributi comuni di Libro e Rivista

	private String IBSN;
	private String titolo;
	private String  annoPubblicazione;
	private String  numeroPagine;
	public Articolo(String IBSN, String titolo, String annoPubblicazione, String numeroPagine) {
		this.IBSN = IBSN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public Articolo() {
		IBSN="abc";
		titolo="Questo articolo non esiste";
		annoPubblicazione="-1";
		numeroPagine="-1";
	}
	public String getIBSN() {
		return IBSN;
	}
	public String getTitolo() {
		return titolo;
	}
	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public String getNumeroPagine() {
		return numeroPagine;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(IBSN+"@");
		
		builder.append(titolo+"@");
		
		builder.append(annoPubblicazione+"@");

		builder.append(numeroPagine+"@");
		return builder.toString();
	}
	
	
	
	
}
