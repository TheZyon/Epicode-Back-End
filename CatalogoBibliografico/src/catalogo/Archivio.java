package catalogo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Archivio {

	static Logger log= LoggerFactory.getLogger(Archivio.class);
	
	private List<Articolo> articoli = new ArrayList<Articolo>();
	


	
	
	
	public Archivio(List<Articolo> articoli) {
		super();
		this.articoli = articoli;
	}

	
	//getters
	public List<Articolo> getArticoli(){
		return articoli;
	}
	
	public List<Libro> getLibri(){ 
		return  articoli.stream().filter(art->(art instanceof Libro))
				.map(lib->(Libro)lib).collect(Collectors.toList());
	}
	
	public List<Rivista> getRiviste(){
		return articoli.stream().filter(art->(art instanceof Rivista))
				.map(riv->(Rivista)riv).collect(Collectors.toList());
	}

	
	//metodi CRUD richiesti dall'esercizio
	public Articolo aggiungiArticolo(Articolo art) throws Exception {
//		controllo che l'elemento non esista già
		if(articoli.stream().anyMatch(a->a.equals(art))) throw new Exception("l'articolo esiste gia!");
		
		else articoli.add(art);
	
		return art;
	}
	
	public  List<Articolo> deleteByISBM(String ISBM) {
		articoli=articoli.stream()
		.filter(art->!art.getIBSN().equals(ISBM))
		.collect(Collectors.toList());
	return articoli;
	}
	
	public Optional<Articolo> getByISBM(String ISBM){
		
		return articoli.stream()
				.filter(art->art.getIBSN().equals(ISBM))
				.max(Comparator.comparing(Articolo::getTitolo));
		
	}
	

	
	public List<Articolo> getByAnnoPubblicazione(int anno ) {
		String annoS=""+anno;
	 return articoli.stream()
				.filter(art->art.getAnnoPubblicazione().equals(annoS))
				.collect(Collectors.toList());
	}
	
	public List<Articolo> getByAutore(String autore){
		
		List<Libro> libriL = getLibri();
		
		return libriL.stream()
				.filter(lib->lib.getAutore().equals(autore))
				.collect(Collectors.toList());
	}
	
	
	/**
	 * Ogni articolo è salvato sul file archivio.txt secondo il formato:
	 * X@campo1@campo2@...@campoN#
	 * 
	 * X -> può essere L o R a seconda che l'articolo è un libro o una rivista
	 * 
	 * @ -> serve a separare i campi dell'articolo
	 * # -> indica il termine della stringa dell'articolo
	 * 
	 * @throws IOException 
	 * */
	public void salvaArchivioSuFile(File file) throws IOException {
		
		
		//1. costruzione stringa da scrivere sul file
		
		
		//1. we will use the stream method REDUCE !
		
		String str= articoli.stream().map(art->articoloToString(art))
				.reduce("", (s,t)->s+t);
		
		FileUtils.writeStringToFile(file, str, "UTF-8");
	}
	
	
	
	public List<Articolo> retrieveFromFile(File file) throws IOException{
		
		String str= FileUtils.readFileToString(file, "UTF-8");
		
		String[] strArt= str.split("#");
		
		return Arrays.asList(strArt).stream()
		.map(stringa->{
			try {
			if(stringa.charAt(0)=='L') {//p la stringa di un libro
				 
				return Libro.fromString(stringa);
				 
			} else return Rivista.fromString(stringa);
			}
			catch(Exception e) {
				log.error(e.getMessage()); 
				return null;}
			
		}).collect(Collectors.toList());
	
	}
	
	
	public static String articoloToString(Articolo art) {
		String res="";
		if(art instanceof Libro)  res=((Libro)art).toString();
		else res=((Rivista)art).toString();
		return res;
	}

	
	
}
