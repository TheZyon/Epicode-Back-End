package utils;


//segnala che si è cercato un elemento con un id che non esiste nella tabella
public class NoSuchElementInDBException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchElementInDBException(String message) {
		super(message);
	}
	public NoSuchElementInDBException() {
		super();
	}
}
