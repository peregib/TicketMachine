package main;

import java.util.ArrayList;
import java.util.List;


public abstract class TicketMachine {
	protected List<Ticket> paidTicketList = new ArrayList<>();
	protected Ticket actualTicket;
	protected int ticketPriceLeft;
	protected static int CoinQuantity = 100;

	public static void chargeCoins(int quantity) {
		CoinQuantity = quantity;
	}
	
	protected class Coin {
		private int value;
		private int count;

		public Coin(int value, int count) {
			this.value = value;
			this.count = count;
		}

		public int getValue() {
			return value;
		}

		public int getCount() {
			return count;
		}

		public void decreaseCountBy(int count) {
			this.count -= count;
		}

		public void increaseCountBy(int count) {
			this.count += count;
		}

	}

	protected Coin[] avaiableCoins = { new Coin(1, CoinQuantity),
			new Coin(2, CoinQuantity), new Coin(5, CoinQuantity),
			new Coin(10, CoinQuantity), new Coin(20, CoinQuantity),
			new Coin(50, CoinQuantity), new Coin(100, CoinQuantity) };
	
	public String listAvaiableCoins() {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < avaiableCoins.length; i++) {
			result.append(avaiableCoins[i].getValue() + " ("
					+ avaiableCoins[i].getCount() + "db);");
		}
		return result.toString();
	}
}
