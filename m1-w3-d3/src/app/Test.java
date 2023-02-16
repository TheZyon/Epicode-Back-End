package app;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DAO.EventoDAO;
import model.Evento;
import model.TipoEvento;

public class Test {
    static Logger log = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		
		
		EventoDAO dao = new EventoDAO();
		
		
		try {
		
			var evento = new Evento( Date.valueOf("1998-04-09"), TipoEvento.PRIVATO, 4);
//			Operazioni CRUD
			
//			dao.create(evento);
			
//			System.out.println(dao.getById(1).toString());

//			dao.update
//			var eTemp=dao.getById(2);
//			eTemp.setDescrizione("evento raro");
//			dao.update(eTemp);
			
//			dao.deleteEvent(dao.getById(3));
			dao.getAll().forEach(l->System.out.println(l.toString()));
		
		}
		catch(Exception e) {log.error(e.getMessage());}
		finally {dao.closeContext();}

	}

}
