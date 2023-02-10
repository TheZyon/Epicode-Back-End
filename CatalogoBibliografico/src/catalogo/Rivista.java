package catalogo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rivista extends Articolo {
	static Logger log = LoggerFactory.getLogger(Rivista.class);
	
	private Periodicita periodicita;

	public Rivista(String IBSN, String titolo, String annoPubblicazione, String numeroPagine, Periodicita periodicita) {
		super(IBSN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}


	public Periodicita getPeriodicita() {
		return periodicita;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("R@");
		builder.append(super.toString());
		builder.append(periodicita.toString()+"#");
		return builder.toString();
	}
	
	public static Rivista fromString(String s) throws Exception {//riceve una stringa del formato X@campo1@campo2@...@campoN
		String[] parts=s.split("@");
		if(parts.length!=6) throw new Exception("formato stringa sbagliato per una rivista");
		else {
		//retrieving the enum value of "periodicità"
		Periodicita p;
		
		switch(parts[5]){
			case "SETTIMANALE" : p= Periodicita.SETTIMANALE; break;
			case "MENSILE": p = Periodicita.MENSILE; break;
			case "SEMESTRALE": p=Periodicita.SEMESTRALE; break;
			default: throw new Exception("campo Periodicità non corrisponde ai tipi consentiti");
		}
		
		return new Rivista(parts[1], parts[2], parts[3], parts[4], p);
		}
	
	}
	
}
