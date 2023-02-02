package esercizio1;

import esercizio1.Dipendente.Dipartimento;

public class CalcolatorePaghe {

public static double calcolaPaga(Dipendente ugo) {
	return ugo.getStipendio();
}

public static double calcolaPaga(Dipendente ugo, int oreStraordinario) {
return ugo.getStipendio()+ugo.getImportoOrarioStraoridinario()*oreStraordinario;	
}


}
