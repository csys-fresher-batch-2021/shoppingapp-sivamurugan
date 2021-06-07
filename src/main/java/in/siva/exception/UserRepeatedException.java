package in.siva.exception;

public class UserRepeatedException extends Exception {
	/**
	 * This method is used to raise user repeated exception
	 */
	private static final long serialVersionUID = 1L;
	public UserRepeatedException(String message) {
		super(message);
	}
}