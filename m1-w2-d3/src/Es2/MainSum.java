package Es2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainSum {

	static Logger log= LoggerFactory.getLogger(MainSum.class);
	public static void main(String[] args) {
		
		
		double[] arrayNums=new double[3000];
		double[] a1=new double[1000];
		double[] a2=new double[1000];
		double[] a3=new double[1000];
		
		//popolamento
		for(int i=0; i<3000; i++) {
			arrayNums[i]=Math.random()*100;
		}
		
		//popolo i tre array parziali
		
		for(int j=0; j<1000;j++) {
			a1[j]=arrayNums[j];
		}
		for(int j=1000; j<2000;j++) {
			a2[j-1000]=arrayNums[j];
		}
		for(int j=2000; j<3000;j++) {
			a2[j-2000]=arrayNums[j];
		}
	
		
		
		PartialSumThread t1=new PartialSumThread(a1);
		PartialSumThread t2=new PartialSumThread(a2);
		PartialSumThread t3=new PartialSumThread(a3);
		
		t1.start();
		t2.start();
		t3.start();
		
		log.info("sum is: "+ (t1.getPartialSum()+t2.getPartialSum()+t3.getPartialSum()));
		
		//controverifica (perché differenze tra le due somme???)
		
		log.info("somma completa: "+sum(arrayNums));
		log.info("somma somme parziali: " + (sum(a1)+sum(a2)+sum(a3)));
		
		
	}

	public static double sum(double[] array) {
		double sum=0;
		
		for(double d:array) {
			sum+=d;
		}
		return sum;
	}
	
}
