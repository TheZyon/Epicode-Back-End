package playerMultimediale;

import java.util.Scanner;

public class ControllerElemento {

	Elemento e;
	Scanner sc;
	boolean[] tipo= new boolean[3];  //segnala il tipo dell'elemento
	boolean haVolume=false;
	boolean haLuminosita=false;
	public ControllerElemento(Elemento e, Scanner sc) {

		this.e = e;
		this.sc=sc;
		this.tipo[0]=e instanceof Audio;
		this.tipo[1]= e instanceof Video;
		this.tipo[2]= e instanceof Immagine;
		if(e instanceof GestioneLuminosita) haLuminosita=true;
		if(e instanceof GestioneVolume) haVolume=true;
		
		
		
		System.out.println("\nHai selezionato l'elemento di tipo "+ 
				e.getClass().getName()+ " dal titolo "+
				"'"+ e.getTitolo() + "'");
		
	}
	
	public boolean mostraEdEseguiOpzioni() {
		String opzioniStr="";
		
		
		if(haVolume) {
			opzioniStr+="\n• premi 1 per aumentare volume, 2 per diminuirlo";
			
		}
		if(haLuminosita) {
			opzioniStr+="\n• premi 3 per aumentare luminosità, 4 per diminuirla";
					
		}
		opzioniStr+="\n• premi 5 per eseguire l'elemento";
		opzioniStr+="\n• premi un numero più grande di 5 per tornare a selezionare altri elementi\n";
		
		System.out.println(opzioniStr);
		
		switch(Player.verificaInput(sc)){ 
		case 1: if(haVolume){((GestioneVolume) e).alzaVolume();}else {System.out.println("\nnon puoi eseguire questa operazione\n");} break;
		case 2: if(haVolume){((GestioneVolume) e).abbassaVolume();}else {System.out.println("\nnon puoi eseguire questa operazione\n");} break;
		case 3: if(haLuminosita){((GestioneLuminosita) e).aumentaLuminosita();}else {System.out.println("\nnon puoi eseguire questa operazione\n");} break;
		case 4: if(haLuminosita){((GestioneLuminosita) e).diminuisciLuminosita();}else {System.out.println("\nnon puoi eseguire questa operazione\n");}break;
		case 5: eseguiElemento(); break;
		default: System.out.println("uscita"); return false;
		}
		return true;
		
		
		
		
	}
	public void eseguiElemento() {
		if(e instanceof ElementoRiproducibile) {
			ElementoRiproducibile er= (ElementoRiproducibile) e;
			er.play();
		}
		else if (e instanceof Immagine){
			Immagine im = (Immagine) e;
			im.show();
		}
	} 
	
	
	
}
