package ca.ubc.cs.cpsc210.meetup.exceptions;

/*
 *  Represent a problem with a course time
 */
public class IllegalTimeException extends Exception {
	
	/**
	 * Constructor
	 * @param msg The message to carry with the exception
	 */
	public IllegalTimeException(String msg) {
		super(msg);
	}

}
