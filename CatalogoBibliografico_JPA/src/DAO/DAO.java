package DAO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Elemento;
import model.Prestito;
import model.Utente;
import utils.JPAUtil;
import utils.NoSuchElementInDBException;



/*
 * General DAO for interating with every table of the DB
 * */

@SuppressWarnings("unchecked") //attenzione: aggiunto per nascondere gli warnings di unchecked cast quando invocato il metodo getResultList() 
public class DAO <T>{

	EntityManagerFactory emf;
	EntityManager em;
	Logger log = LoggerFactory.getLogger(DAO.class);
	public DAO() {
		emf= JPAUtil.getEntityManagerFactory();
		em=emf.createEntityManager();
	}
	
	public void closeAll() {
		em.close();
		emf.close();
	}
	
	//operazioni CRUD
	
	//create
	public void create(T t) {
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();
		
		log.info("CREATED IN DB: "+ t.toString());

	}
	
	
	//retrieve

	public T getById(String className, int id) throws NoSuchElementInDBException {
			List<T> list=null;
		
			em.getTransaction().begin();
			
		
			list= em.createQuery("SELECT i FROM "+ className+" i" +" WHERE id="+id).getResultList();
			em.getTransaction().commit();
			
			if(list.size()>0) return (T) list.get(0);
			else throw new NoSuchElementInDBException();
			
			
	}

	public List<T> getAll(String className){
		em.getTransaction().begin();
		
		List<T> t = (List<T>) em.createQuery("SELECT c FROM "+ className + " c" ).getResultList();
		
		em.getTransaction().commit();
		return t;
	} 
	

	public List<Elemento> getElementiByAnnoPubblicazione(int annoPubblicazione){
		
		List<Elemento> list = null;
		
		em.getTransaction().begin();
		
//		list =  em.createQuery("SELECT e FROM Elemento e WHERE e.anno_pubblicazione="+annoPubblicazione)
//				.getResultList();
		
		list= em.createNamedQuery("getByAnnoPubblicazione").setParameter("anno", annoPubblicazione)
				.getResultList();
		
		em.getTransaction().commit();
		
		return list;
		
	}
	
	
	public List<Elemento> getElementiByAutore(String autore){
		List<Elemento> list=null; 
		em.getTransaction().begin();
		
		list =  em.createQuery("SELECT e FROM Elemento e WHERE e.autore='"+autore+"'")
				.getResultList();
		
		em.getTransaction().commit();
		return list;
	} 
	
	public List<Elemento> getElementiByTitolo(String titolo){
		List<Elemento> list=null; 
		em.getTransaction().begin();
		
		list=em.createNamedQuery("getByTitolo").setParameter("titolo", titolo).getResultList();
		
		em.getTransaction().commit();
		return list;
	}
	
	public List<Prestito> getPrestitiUtente(Utente u){
		
		List<Prestito> list=null; 
		em.getTransaction().begin();
		
		list=em.createNamedQuery("prestitiPerUtente").setParameter("numero_tessera", u).getResultList(); //prestiti Utente
		em.getTransaction().commit();
		
		return list;
	}
	public List<Prestito> getPrestitiAttiviUtente(Utente u){
		//verifico, tra gli elementi prestati all'utente, quali non hanno una data di restituzione effettiva
		return getPrestitiUtente(u).stream()
				.filter(p->p.getData_restituzione_effettiva()==null)
				.collect(Collectors.toList());
		
	}

	public List<Prestito> getPrestitiScadutiENonRestituiti(){
		List<Prestito> list = (List<Prestito>) getAll("Prestito");
		
		return list.stream().filter(p->p.getData_restituzione_effettiva()==null) //non ancora restituiti
		.filter(p->p.getData_restituzione_prevista().getTime()<System.currentTimeMillis())
		.collect(Collectors.toList());
		
		
	}
	
	//update 
	
	public void merge(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}


	//delete
	public void delete(T t) throws Exception {
		
		
		em.getTransaction().begin();
		
		em.remove(t);
		
		em.getTransaction().commit();
	}
	
	public void deleteById(String className, int id) throws Exception {
	// si recupera l'elemento dal db, quindi si usa il metodo delete() (r.77) per rimuoverlo
	
		T t = getById(className, id);		
		delete(t);
		
	}

	public EntityManager getEm() {
		return em;
	}
	
	
}
