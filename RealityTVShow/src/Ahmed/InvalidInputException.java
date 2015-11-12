/**
 * 
 */
package Ahmed;

/**
 * 
 * This is a reality TV show program that formats the contestant's information
 *This exception handling class ultimately sends messages to the user if the input the wrong in formation or if it is not in the proper format
 * 
 * @author Faduma Ahmed 
 * Sept 28 - november 11 , 2015
 * 
 */
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	public InvalidInputException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public InvalidInputException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidInputException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
