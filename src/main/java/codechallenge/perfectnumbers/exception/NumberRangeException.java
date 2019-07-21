package codechallenge.perfectnumbers.exception;

/**
 * @author kolin
 *
 */
public class NumberRangeException extends Exception {


	private static final long serialVersionUID = 1L;

	public NumberRangeException() {
        super();
    }

    public NumberRangeException(String message) {
        super(message);
    }

    public NumberRangeException(String message, Throwable cause) {
        super(message, cause);
    }
}