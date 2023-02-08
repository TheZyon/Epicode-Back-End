package Es1;

public class Main1 {

	public static void main(String[] args) {
		var t1 = new Thread1("#");
		var t2= new Thread1("@");
		
		t1.start();
		t2.start();
		
		
	}

}
