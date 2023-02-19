package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DAO.DAO;
import model.Elemento;


public class MainProject {
	
	static DAO dao = new DAO(); //parametrizzarlo di volta in volta con generic per il tipo di operazioni che si vogliono fare
	public static Logger log = LoggerFactory.getLogger(MainProject.class);
	public static void main(String[] args) {
		
		try {
			
//			##### POPOLAMENTO DB #####
//			dao.create(new Utente("Maria Mario", "Marielli", Date.valueOf("1540-12-25")));
//			dao.create(new Utente("Mariellino", "Von Marielli", Date.valueOf("1935-12-25")));
//			dao.create((Elemento) new Libro("Vita Mariello",2000, 300, "Mariello Marielli", "Biologia"));
//			dao.create((Elemento) new Rivista("Mariello weekly", 1999, 24, Periodicita.SETTIMANALE));
			
//			Utente u = new Utente("Alba", "Parielli", Date.valueOf("1903-12-25"));
//			var e = new Libro("Carnevale Viareggio",2000, 120, "Baby Birba", "Antropologia");
//			var prestito = new Prestito(u, e, Date.valueOf("2005-12-25"), Date.valueOf("2006-02-20"));
//			dao.create(prestito);
			
//			dao.create((Prestito) new Prestito((Utente)dao.getById("Utente", 1), (Elemento)dao.getById("Elemento", 1), Date.valueOf("2023-01-01"), Date.valueOf("2023-02-30")));
			
//			dao.create((Prestito) new Prestito((Utente)dao.getById("Utente", 1), (Elemento)dao.getById("Elemento", 2), Date.valueOf("2023-01-01"), Date.valueOf("2023-01-15")));
//			dao.create((Prestito) new Prestito((Utente)dao.getById("Utente", 1), (Elemento)dao.getById("Elemento", 4), Date.valueOf("2023-01-01")));
//			dao.create((Prestito) new Prestito((Utente)dao.getById("Utente", 1), (Elemento)dao.getById("Elemento", 5), Date.valueOf("2023-01-01")));
			
			
			
			
			
//			dao.create((Elemento) new Libro("Come diventare famosi vendendo aria fritta",2020, 15, "Chiara Ferragni", "Businessi"));
//			dao.create((Elemento) new Libro("Tik tok come mezzo di realizzazione esistenziale",2020, 16, "Chiara Ferragni", "Businessi"));
//			dao.create((Elemento) new Libro("Perché noi veliamo...con le calze",2020, 17, "Chiara Ferragni", "Sessismo"));
//			dao.create((Elemento) new Libro("Il mio nuovo saggio: Gesù, il primo influencer",2020, 18, "C.F.", "Temino 5a elementare"));
//			dao.create((Elemento) new Rivista("Chi", 2020, 15, Periodicita.SETTIMANALE));
//			dao.create((Elemento) new Rivista("Chicchessia", 2021, 10, Periodicita.SETTIMANALE));
//			

			

//			RICHIESTE PROGETTO
			
//			1.Aggiunta elemento nel catalogo (vedi r. 31-34 di questa classe)
		
//			2.Eliminazione elemento dal catalogo, dato ISBM
//				dao.deleteById("Elemento", 3); //osservare che vengono anche eliminati i prestiti associati, quindi funziona il cascade type remove
		
//			3.Read elemento by ISBM
//			System.out.println((Elemento)dao.getById("Elemento", 2));
			
//			4.Read elementi by anno pubblicazione
//			
//			dao.getElementiByAnnoPubblicazione(2020).forEach(e->System.out.println(e));
//			getElementiByAnnoPubblicazione(2021); //aggiunto output grafico
			
//			5. Read elementi by autore
//			dao.getElementiByAutore("Chiara Ferragni").forEach(e->log.info(e.toString()));
			
//			6. Read elementi by titolo
//			dao.getElementiByTitolo("%Mariello%").forEach(e->log.info(e.toString()));
			
//			7. Elementi attualmente in prestito ad utente, noto il suo numero tessera
//			dao.getPrestitiAttiviUtente((Utente)dao.getById("Utente", 1)).forEach(p->log.info(p.toString()));
			
//			8. Tutti i prestiti scaduti e non ancora restituiti	
//			dao.getPrestitiScadutiENonRestituiti().forEach(p->log.info(p.toString()));
			
			
		} 
//		catch (NoSuchElementInDBException e) {log.error("il tale id non esiste");} //togliere commento quando si usa r.51
		catch (Exception e) {e.printStackTrace();}
		finally {dao.closeAll();}
		

	}



	static public List<Elemento> getElementiByAnnoPubblicazione(int anno) {
		log.info("init");
		List<Elemento> list = dao.getElementiByAnnoPubblicazione(anno);
		if(list.size()==0) log.info("no element was published in that year");
		else list.forEach(e->System.out.println(e));
		return list;
	}
	
	
}
