package Es1;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main1 {

	
	static final Logger log = LoggerFactory.getLogger(Main1.class);
	
	
	public static void main(String[] args) {
		
		boolean cont=true;
		
		Set<String> s=new HashSet<String>(); //set principale
		Set<String>dupl=new HashSet<String>(); //set che conterrà le parole duplicate
		
		while(cont) {
		System.out.println("Inserisci il size del set delle parole:");
		int size = MyScanner.scanInt();
		
		if(size!=-1) { //se input corretto
			
			for(int i=0; i<size; i++) { //inserimento parole
		
			System.out.println("\nInselisce palola-"+(i+1)+": \n");
			
			String str=MyScanner.nextLine();
			if(!s.add(str)) { //se la parola era già stata inserita nel set
				dupl.add(str);
				log.error(str + " c'era già");
			}
			
			}
			
		//stampa info	
//		log.info("parole inserite più di una volta: ");
//		stampa(dupl);
//		log.info("numero parole distinte: "+ s.size());
		log.info("parole inserite senza duplicazione: ");
		stampa(s);	
		cont=false;
		
		}
		}
		
		
	}

	
	
	
	public static void stampa(Collection c) {
		c.forEach(e->{System.out.println(e);});
	}
	public static int scanInt() {
		int res=-1;
		try {
		   String s= MyScanner.nextLine();
		   res=Integer.parseInt(s);
		   
		}
		catch(NoSuchElementException e){System.out.println("non hai scritto niente!");}
		catch(NumberFormatException e) {System.out.println("Number format exception!");}
		
		return res;
	}
	
	
	
}
