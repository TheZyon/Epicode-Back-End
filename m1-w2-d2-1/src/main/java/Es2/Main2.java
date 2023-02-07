package Es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Es1.Main1;

public class Main2 {
	static final Logger log = LoggerFactory.getLogger(Main1.class);
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		List<Integer> list= randomList(5);
		
		list=specchio(list);
		
		
		for(int i=0; i<list.size(); i++) {
			log.info(i+ " "+list.get(i));
		}
		

		
	}

	
public static List<Integer> randomList(int n){
	List<Integer> list = new ArrayList<Integer>();
	
	for(int i=0; i<n; i++) {
		list.add((int) Math.round(Math.random()*(n-1)+1));
	}
	
	return list;
}

public static List<Integer> specchio(List<Integer> list){
	
	
	List<Integer> listCopy= new ArrayList<Integer>();
	listCopy.addAll(list);
	Collections.reverse(listCopy);
	
	list.addAll(listCopy);
	return list;
	
	
}

public static void stampaPariDispari(List<Integer> list, boolean b) {
	
	if(b) {for(int i=0; i<list.size(); i+=2) {
		log.info(i+" "+ list.get(i));
	}}
	else for(int i=1; i<list.size(); i+=2) {
		log.info(i+" "+ list.get(i));
	}
	
	
}



}
