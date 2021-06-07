package in.siva.exception;

public class VegInvalidException extends RuntimeException{
	/**
	 * This method is used to raise product invalid message
	 */
	private static final long serialVersionUID = 1L;
		public VegInvalidException(String message) {
			super(message);
	}
}
