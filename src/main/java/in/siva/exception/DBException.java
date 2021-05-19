package in.siva.exception;

public class DBException extends Exception{
	/**
	 * This method is used to define DB exceptions
	 */
	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}
}
