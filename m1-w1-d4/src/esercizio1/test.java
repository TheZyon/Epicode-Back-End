package esercizio1;

import esercizio1.Dipendente.Dipartimento;

public class test {

	public static void main(String[] args) {
	
		Dipendente pierDellaVigna= new Dipendente("asdfghj23456",Dipartimento.PRODUZIONE);
		
		System.out.println(calcolaPaga(pierDellaVigna));
		
		pierDellaVigna.stampaDatiDipendente();
		
		pierDellaVigna.promuovi();
		
		pierDellaVigna.stampaDatiDipendente();
		
		System.out.println(calcolaPaga(pierDellaVigna, 4));
		
	}
public static double calcolaPaga(Dipendente ugo) {
	return ugo.getStipendio();
}

public static double calcolaPaga(Dipendente ugo, int oreStraordinario) {
return ugo.getStipendio()+ugo.getImportoOrarioStraoridinario()*oreStraordinario;	
}


}
