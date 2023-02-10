package catalogo;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTestArchivio {
	static Logger log = LoggerFactory.getLogger(MainTestArchivio.class);
	static File file = new File("dirFile/archivio.txt");
	public static void main(String[] args) {

		List<Articolo> articoli = Stream.of(
						new Libro("LAI1", "Cani Sonati Collection", "1997", "200", "Zyon Bocchiny", "libro serio"),
						new Rivista("RAI1", "Chi", "1024", "24", Periodicita.SETTIMANALE),
						new Libro("LAI2", "Io sono Giorgia", "2021", "200", "Giorgia Meloni (o chi per lei)", "ortofrutta"),
						new Rivista("RAI2", "Chi l'ha visto?", "2022", "20", Periodicita.SETTIMANALE),
						new Rivista("RAI3", "Dragonball GP", "2023", "22", Periodicita.MENSILE),
						new Libro("LAI3", "Italia paese perbene", "2022", "200", "Alfredo Ingraldo", "satira"))
				.collect(Collectors.toList());


		var archivio = new Archivio(articoli);

		
//		1. aggiungiArticolo() test 
//		try {
//			archivio.aggiungiArticolo(new Rivista("RAI4", "Hot Stuff", "2023", "20", Periodicita.SETTIMANALE));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("il libro c'è già");
//		}
//		printArchivio(archivio);
		
		
//		2. deleteByISBM() test		
//		archivio.deleteByISBM("LAI1");
//		
//		printArchivio(archivio);
		
		
//		3. getByISBM() test
//		log.info(archivio.getByISBM("LAI1").orElse(new Libro()).toString());
//		log.info(archivio.getByISBM("carlino").orElse(new Libro()).toString());
		
		
//		4. getByAnnoPubblicazione() test
			archivio.getByAnnoPubblicazione(2021).forEach(a->log.info(a.toString()));
		
		
//		5. getByAutore() test
		archivio.getByAutore("Alfredo Ingraldo").forEach(a->log.info(a.toString()));

//		6. salvaArchivioSuFile() test
//		
//		try {
//			archivio.salvaArchivioSuFile(file);
//		} catch (IOException e) {
//			log.error(e.getMessage());
//		}
		
//		7. retrieveFromFile() test
		
//		List<Articolo> retrievedList=new ArrayList<Articolo>();
//		try{
//			retrievedList=archivio.retrieveFromFile(file);
//			retrievedList.forEach(art->log.info(Archivio.articoloToString(art)));} 
//		
//		catch(IOException e) {log.error(e.getMessage());}
		
		
		
		
		
	}

	public static void printArchivio (Archivio a) { //printa gli elementi formattati (in stringhe per il file) dell'archivio 
		a.getArticoli().forEach(art->log.info(Archivio.articoloToString(art)));
	}
	
	
}

//		List<String> list = Stream.of("carmelo", "giovanni", "carla")
//							.collect(Collectors.toList());
//		
//		String test="";
//		String r=list.stream().reduce("", (a,b)->a+" "+ b);
//		log.info(r);
