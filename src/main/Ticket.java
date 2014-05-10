package main;

public class Ticket {
	private int TicketId;
	private int TicketPrice;

	public Ticket(int ticketId, int ticketPrice) {
		TicketId = ticketId;
		TicketPrice = ticketPrice;
	}

	public int getTicketId() {
		return TicketId;
	}

	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}

	public int getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		TicketPrice = ticketPrice;
	}

}
