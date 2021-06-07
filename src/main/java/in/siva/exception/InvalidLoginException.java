package in.siva.exception;

public class InvalidLoginException extends RuntimeException{
	/**
	 * This method is used to raise invalid user 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidLoginException(String message) {
		super(message);
	}
}
