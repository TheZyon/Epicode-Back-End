package Es2;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSum {

	static Logger log= LoggerFactory.getLogger(MainSum.class);
	public static void main(String[] args) {
		
		
		double[] arrayNums=new double[3000];

		
		double[][] a= new double[1000][1000];
		
		
		
		//popolamento
		for(int i=0; i<3000; i++) {
			arrayNums[i]=Math.random()*100;
		}
		
	
	
		for(int i=0; i<3; i++) {
			for(int j=1000*i; j<1000*(i+1); j++) {
				a[i][j-1000*i]=arrayNums[j];
			}
		}
		
		PartialSumThread[] t = {new PartialSumThread(a[0]), new PartialSumThread(a[1]), new PartialSumThread(a[2])};
		List<PartialSumThread> l= Arrays.asList(t);
		
		
		l.forEach(p->p.start());
		
		
		
		log.info("somma attuale t[2]: "+t[2].getPartialSum() + " -> osservare come ancora non ha completato la somma");
		log.info("somma a[2]: "+sum(a[2]));
		
		
		try {
			t[0].join();
			t[1].join();
			t[2].join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double [] pSums= {t[0].getPartialSum(), t[1].getPartialSum(), t[2].getPartialSum()};
		
		log.info("sum is: "+ sum(pSums));
		
		//controverifica (perché differenze tra le due somme???)
		
		log.info("somma completa: "+sum(arrayNums));
		log.info("somma somme parziali: " + (sum(a[0])+sum(a[1])+sum(a[2])));
	
		
	}

	public static double sum(double[] array) {
		double sum=0;
		
		for(double d:array) {
			sum+=d;
		}
		return sum;
	}
	
}
