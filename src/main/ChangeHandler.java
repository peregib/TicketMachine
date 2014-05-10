package main;

import java.util.ArrayList;
import java.util.List;

public class ChangeHandler extends TicketMachine {
	
	public ChangeHandler(PaymentHandler actualPaymentHandler) {
		this.ticketPriceLeft = actualPaymentHandler.ticketPriceLeft;
		this.avaiableCoins = actualPaymentHandler.avaiableCoins;
	}

	public void assembleChange() throws CantGetBackChangeException {
		List<Coin> ChangeQueue = new ArrayList<>();
		ticketPriceLeft = ticketPriceLeft * -1;
		if (ticketPriceLeft > 0) {
			for (int i = avaiableCoins.length; i > 0; i--) {
				int howmany = ticketPriceLeft / avaiableCoins[i - 1].getValue();
				if (howmany != 0) {
					if (avaiableCoins[i - 1].getCount() >= howmany) {
						ChangeQueue.add(new Coin(avaiableCoins[i - 1]
								.getValue(), howmany));
						ticketPriceLeft -= howmany
								* avaiableCoins[i - 1].getValue();
						avaiableCoins[i - 1].decreaseCountBy(howmany);
					}
				}
			}
		}
		if (ticketPriceLeft != 0) {
			resetTicketPayment(ChangeQueue);
			throw new CantGetBackChangeException();
		}
		returnChange(ChangeQueue);
	}

	public void returnChange(List<Coin> Change) {
		for (int i = 0; i < Change.size(); i++) {
			System.out.println("Giving back " + Change.get(i).getCount()
					+ " pieces of " + Change.get(i).getValue());
		}
	}

	private void resetTicketPayment(List<Coin> Change) {
		for (int i = 0; i < Change.size(); i++) {
			for (int j = 0; j < avaiableCoins.length; j++) {
				if (Change.get(i).getValue() == avaiableCoins[j].getValue()) {
					avaiableCoins[j].increaseCountBy(Change.get(i).getCount());
				}
			}
		}
	}
}
