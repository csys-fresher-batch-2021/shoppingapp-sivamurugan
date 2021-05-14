package in.siva.exception;

public class UserRepeatedException extends RuntimeException {
	public UserRepeatedException(String message) {
		super(message);
	}
}