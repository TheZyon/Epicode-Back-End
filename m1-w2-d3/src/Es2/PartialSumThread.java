package Es2;

public class PartialSumThread extends Thread {

	private double[] numArray;
	private double partialSum=0;
	public PartialSumThread(double[] numArray) {
		this.numArray=numArray;
	}

	@Override
	public void run() {
	
	
	for(double d : numArray) {
		partialSum+=d;
	}
	
	
	
	}

	public double getPartialSum() {
		return partialSum;
	}

	
	
	
}
