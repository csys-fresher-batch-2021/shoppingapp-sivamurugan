package in.siva.exception;

public class ProductInvalidException extends RuntimeException{
	/**
	 * This method is used to raise product invalid message
	 */
	private static final long serialVersionUID = 1L;

		public ProductInvalidException(String message) {
			super(message);
	}
}
