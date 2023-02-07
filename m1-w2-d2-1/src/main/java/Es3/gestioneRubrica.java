package Es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class gestioneRubrica {
	private static Logger log= LoggerFactory.getLogger(gestioneRubrica.class);
	
	private Map<String, String> m = new HashMap<String,String>();
	
	public boolean create(String nome, String cell) {
		boolean res=false;
		try {
			m.put(nome, cell);
			res=true;
			}
		catch(Exception e) {log.error(e.getMessage());}
		
		return res;
	}
	
	public boolean deleteByName(String nome) {
		boolean res=false;
		try {
			m.remove(nome);
			res=true;
			}
		catch(Exception e) {log.error(e.getMessage());}
		
		return res;
	}
	
	public String getNameByCell(String cell) {
		String name=null;
		
		try {
			if(m.containsValue(cell)) {
			Set<String> names= m.keySet();
			for(String nam : names) {
				if(m.get(nam)==cell) name=nam;
			}
			
				
			}else log.error("the map doesn't have that value!");
			
			}
		catch(Exception e) {log.error(e.getMessage());}
		
		
		return name;
		
	}
	
	public String getCellByName(String name) {
		String cell=null;
		try {
		cell=m.get(name);
		}catch(Exception e) {log.error(e.getMessage());}
		return cell;
	}
	
	public void printAll() {
		
		Set<String> names=m.keySet();
		
		names.forEach(name->log.info(name + " "+ m.get(name)));
		
		
	}
	
	
}
