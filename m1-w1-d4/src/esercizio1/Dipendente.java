package esercizio1;

public class Dipendente {
 
	public static final double stipendioBase=1000;
 
 private String matricola;
 
 private double stipendio;
 
 private double importoOrarioStraoridinario;
 
 public static enum Livello {MERDACCIA, OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE};
 public static enum Dipartimento{PRODUZIONE, AMMINISTRAZIONE, VENDITE};

 private Livello level;
 private Dipartimento dipartimento;
 
 
 //constructors
 public Dipendente(String matricola, Dipartimento dipartimento) {
		
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio=stipendioBase;
		this.importoOrarioStraoridinario=30;
		this.level=Livello.OPERAIO;
	}
	 
 public Dipendente(String matricola, double stipendio, double importoOrarioStraoridinario, Livello level,
			Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraoridinario = importoOrarioStraoridinario;
		this.level = level;
		this.dipartimento = dipartimento;
	}

 //main methods
 
 public void stampaDatiDipendente() {
	 System.out.println(
			 "matricola: "+ matricola+"\n"+
			 "stipendio: "+ stipendio +"\n"+
			"importo orario straordinario: "+ importoOrarioStraoridinario+ "\n"+
			"livello: "+ level+"\n"+
			"dipartimento: "+ dipartimento);
 }
 
 public Livello promuovi() {
	 if(level.equals(Livello.OPERAIO)) {level=Livello.IMPIEGATO; stipendio=stipendioBase*1.2; return level;}
	 if(level.equals(Livello.IMPIEGATO)) {level=Livello.QUADRO;stipendio=stipendioBase*1.5;  return level;}
	 if(level.equals(Livello.QUADRO)) {level=Livello.DIRIGENTE; stipendio=stipendioBase*2; return level;}
	 if(level.equals(Livello.DIRIGENTE)) {System.out.println("errore, già dirigente"); return level;}
	 else {return level;}
 }
 
 
 //getters & setters
public String getMatricola() {
	return matricola;
}
public void setMatricola(String matricola) {
	this.matricola = matricola;
}
public double getStipendio() {
	return stipendio;
}

public double getImportoOrarioStraoridinario() {
	return importoOrarioStraoridinario;
}
public Livello getLevel() {
	return level;
}

public Dipartimento getDipartimento() {
	return dipartimento;
}
public static double getStipendiobase() {
	return stipendioBase;
}
 
public void setDipartimento(Dipartimento dipartimento) {
	this.dipartimento = dipartimento;
}
 public void setImportoOrarioStraoridinario(double importoOrarioStraoridinario) {
	this.importoOrarioStraoridinario = importoOrarioStraoridinario;
}

 

}
