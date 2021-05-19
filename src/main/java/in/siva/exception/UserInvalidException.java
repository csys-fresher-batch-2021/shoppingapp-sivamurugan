package in.siva.exception;

public class UserInvalidException extends RuntimeException {
	/**
	 * This method is used to raise user invalid exception
	 */
	private static final long serialVersionUID = 1L;

	public UserInvalidException(String message) {
		super(message);
	}
}
