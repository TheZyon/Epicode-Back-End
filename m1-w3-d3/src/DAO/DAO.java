package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import utils.JpaUtil;

public class DAO <T>{

	EntityManagerFactory emf;
	EntityManager em;
	
	public DAO() {
		emf= JpaUtil.getEntityManagerFactory();
		em=emf.createEntityManager();
	}
	
	public void closeAll() {
		em.close();
		emf.close();
	}
	
	//operazioni CRUD
	
	public void merge(T t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
	}
	public void create(T t) {
		em.getTransaction().begin();
		
		em.persist(t);
		
		em.getTransaction().commit();

	}
	
	public T getById(String className, int id) throws Exception {
			em.getTransaction().begin();
			
		
			var list= em.createQuery("SELECT i FROM "+ className+" i" +" WHERE id="+id).getResultList();
			em.getTransaction().commit();
			
			if(list.size()>0) return (T) list.get(0);
			else throw new Exception("nessun elemento ha quell'id!");
			
			
	}
	
	
	public List<T> getAll(String name){
		em.getTransaction().begin();
		
		List<T> t = (List<T>) em.createQuery("SELECT c FROM "+ name + " c" ).getResultList();
		
		em.getTransaction().commit();
		return t;
	} 
	
	//implementare update 
	
	
	public void delete(T t) throws Exception {
		
		
		em.getTransaction().begin();
		
		em.remove(t);
		
		em.getTransaction().commit();
	}
	
	
}
