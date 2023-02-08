package Es2;

public class PartialSumThread extends Thread {

	private double[] numArray;
	private double partialSum=0;
	public PartialSumThread(double[] numArray) {
		this.numArray=numArray;
	}

	@Override
	public void run() {
	
	
	partialSum=MainSum.sum(numArray);
	
	}

	public double getPartialSum() {
		return partialSum;
	}

	
	
	
	
}
