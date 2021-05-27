package in.siva.exception;

public class EmptyBillException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * It will throw a Invalid Bill Exception if bill values are not valid
	 */
	public EmptyBillException(String message) {
		super(message);
	}
}
