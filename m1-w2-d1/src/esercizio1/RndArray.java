package esercizio1;

public class RndArray {

		private int[] array= new int[5];
		
		RndArray() {
			
			//popolo l'array con rnd da 1 a 10
			for(int i =0; i<5; i++) {
				array[i]=(int) Math.round(Math.random()*9+1);
			}
		}
		
		public void stampaArray() {
			
			for(int i : array) {
				System.out.println(i);}
		}
		public void setElementByIndex(int index, int value) throws ArrayIndexOutOfBoundsException{
			
		array[index]=value;
		
		}
		
	
	
}
