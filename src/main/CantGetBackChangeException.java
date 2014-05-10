package main;

public class CantGetBackChangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CantGetBackChangeException(){
		super("Sorry, I can't get back change. Payment reseted.");
	}

}
