package Es1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread1 extends Thread {

	
	
	Logger log = LoggerFactory.getLogger(Thread1.class);
	private String symbol;
	
	public Thread1(String symbol) {
		this.symbol=symbol;
	}
	
	
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				log.error(e.getMessage());
			}
			System.out.println((i+1)+" - "+ symbol);
			
			
		}
	}

}
