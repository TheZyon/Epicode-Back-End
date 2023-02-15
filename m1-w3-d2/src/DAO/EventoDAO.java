package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Evento;
import utils.JpaUtil;

public class EventoDAO <T> {
static Logger log= LoggerFactory.getLogger(EventoDAO.class);
	private EntityManagerFactory emf;
	private EntityManager em;
	public EventoDAO() {
	emf=JpaUtil.getEntityManagerFactory();
	em=emf.createEntityManager();
	}
	
	public void closeContext() {
		em.close();
		emf.close();
	}
	public void create(Evento e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
	}

	public Evento getById(int id) {
		em.getTransaction().begin();
		var ev= em.find(Evento.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	
	public Evento update(Evento e) {
		em.getTransaction().begin();
		var ev= em.merge(e);
		em.getTransaction().commit();
		return ev;
	}
	
	public void deleteEvent(Evento e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
	public List<Evento> getAll(){
		List<Evento>list=null;
		em.getTransaction().begin();
		
		list=em.createQuery("SELECT e FROM Evento").getResultList();
		
		
		em.getTransaction().commit();
		return list;
	}
	
	
}
