package utils;

public interface SuccessivoMod {

	
	public static int successivo(int mod, int i) {
		var res=(i<mod)?i+1: 1;
		return res;	
	}
}
