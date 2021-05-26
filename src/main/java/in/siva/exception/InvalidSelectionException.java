package in.siva.exception;

public class InvalidSelectionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be thrown when any problem occurs in selection of products by user
	 */
	public InvalidSelectionException() {
		super("Sorry! Something went wrong.. Please select products again");
	}
	
	// Method overloading
	public InvalidSelectionException(String message) {
		super(message);
	}
}
