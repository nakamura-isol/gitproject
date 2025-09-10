package javadrill.exercise019.question028;

public class InvalidCredentialsException extends Exception {
	InvalidCredentialsException(String message) {
		super(message);
	}

	InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

}
