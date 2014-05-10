package main;

import java.util.Random;

public class PaymentHandler extends TicketMachine {
	
	public int generateTicketPrice() {
		Random randomGenerator = new Random();
		int generatedPrice = randomGenerator.nextInt(101) + 1;
		return generatedPrice;
	}

	public void isTicketAlreadyPayed(int TicketId)
			throws TicketAlreadyPayedException {
		int i;
		for (i = 0; i < paidTicketList.size(); i++) {
			if (paidTicketList.get(i).getTicketId() == TicketId) {
				throw new TicketAlreadyPayedException();
			}
		}
	}

	public void setPayingTicket(Ticket payingTicket) {
		actualTicket = payingTicket;
		ticketPriceLeft = actualTicket.getTicketPrice();
	}

	public int getTicketPriceLeft() {
		return ticketPriceLeft;
	}

	public void ifValidCoinDecreasePriceLeftBy(int coin) {
		for (int i = 0; i < avaiableCoins.length; i++) {
			if (avaiableCoins[i].getValue() == coin) {

				ticketPriceLeft -= coin;
			}
		}
	}

	public void SaveTicket() {
		paidTicketList.add(actualTicket);
	}
}
