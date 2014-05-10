package main;

public class TicketAlreadyPayedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TicketAlreadyPayedException() {
		super("Ticket already payed!");
	}
}
