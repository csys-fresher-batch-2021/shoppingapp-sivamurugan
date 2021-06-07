package in.siva.exception;

public class EmptyOrderException extends Exception{
	private static final long serialVersionUID = 1L;
	public EmptyOrderException(String message) {
		super(message);
	}
}
