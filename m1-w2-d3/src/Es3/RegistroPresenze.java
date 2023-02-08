package Es3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {

	static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	
	static File file= new File("fileDir/presenze.txt");
	
	private List<Presenza> presenze;
	
	
	public RegistroPresenze(List<Presenza> presenze) {
		
		this.presenze = presenze;
	}


	public String convertListToString() {
		
//		presenze.forEach(p->System.out.println(p.getNome())); 
		
		String res="";
		for(Presenza p: presenze) {res+=p.getNome() + "@" +p.getnGiorniPresenza()+"#";}
		
		return res;
	}
	
	
	public void createPresenze() throws IOException { //storicizza le presenze su un file
		
		
		FileUtils.writeStringToFile(file,convertListToString() , "UTF-8");
		
	}
	
	
	public String readPresenze() throws IOException{
		return FileUtils.readFileToString(file, "UTF-8");
	}
	
	public List<Presenza> convertStringToList(String s){
		
		List<Presenza> res=new ArrayList<Presenza>();
		
		//1. creo una lista con i caratteri della stringa
		
		
		//1.
		char[] chars=s.toCharArray();
		
		Character[] cArray= new Character[chars.length];
		
		for(int i=0; i<chars.length; i++) {
			cArray[i]=(Character)chars[i];
		}
		
		List<Character> list= Arrays.asList(cArray);
		
		
				
		Iterator it= list.iterator();		
		Presenza p = new Presenza("Zyoneccio");
		
		String name="";
		String presenze="";
		String current="";
		
		while(it.hasNext()) {
			
			
			Character c = (Character) it.next();
			log.info(String.valueOf(c));
			
			try {
			switch(c) {
			case '@': 
				//è finito un nome
				log.info("case @");
				name="";
				name+=current;
				log.info("in name ho salvato: "+name);
				current="";
				break;
				
			case '#': 
				//è finito il numero presenze
				log.info("case #");
				presenze="";
				presenze+=current;
				log.info("in presenze ho salvato: "+ presenze);
				log.info("in name ho salvato: "+name);
				current="";
				res.add(new Presenza(name, Integer.parseInt(presenze)));
				break;
				
			default: 
				log.info("letter");
				current+=String.valueOf(c);
				log.info(current);
				
			}}
			catch(Exception e) {log.error("errore nel switch "+ e.getMessage());}
		
		
		}
		
		return res;
			
			
		}
		
}
	

