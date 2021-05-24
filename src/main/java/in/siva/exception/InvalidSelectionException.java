package in.siva.exception;

public class InvalidSelectionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidSelectionException() {
		super("Sorry! Something went wrong.. Please select products again");
	}
	
	public InvalidSelectionException(String message) {
		super(message);
	}
}
