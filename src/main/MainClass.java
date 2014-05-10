package main;

import java.io.*;

public class MainClass {

	@SuppressWarnings("finally")
	private static int askForIntegerUserInput(String outputMessage) {
		int result = 0;
		System.out.println(outputMessage);
		try {
			BufferedReader gui = new BufferedReader(new InputStreamReader(
					System.in));
			result = Integer.valueOf(gui.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	public static void PayTicket(int WitchTicket,PaymentHandler WitchPaymentHandler) {
		int TicketPrice = WitchPaymentHandler.generateTicketPrice();
		Ticket t = new Ticket(WitchTicket, TicketPrice);
		WitchPaymentHandler.setPayingTicket(t);
		System.out.println("Please pay: " + t.getTicketPrice()
				+ ". You can use coins: " + WitchPaymentHandler.listAvaiableCoins());
		while (true) {
			int InsertedCoin = askForIntegerUserInput("Inserted coin(remaining :"
					+ WitchPaymentHandler.getTicketPriceLeft() + ")");
			WitchPaymentHandler.ifValidCoinDecreasePriceLeftBy(InsertedCoin);
			if (WitchPaymentHandler.getTicketPriceLeft() <= 0) {
				System.out.println("Ticket payed. Rest: "
						+ WitchPaymentHandler.getTicketPriceLeft()
						+ ", still avaiable coins: "
						+ WitchPaymentHandler.listAvaiableCoins());
				try {
					new ChangeHandler(WitchPaymentHandler).assembleChange();
					WitchPaymentHandler.SaveTicket();
				} catch (CantGetBackChangeException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		TicketMachine.chargeCoins(1);//csak hogy hamarabb elfogyjon a gépbõl az apró
		PaymentHandler ph = new PaymentHandler();
		while (true) {
			int guiInput = askForIntegerUserInput("Please enter Ticket ID (0: Exit program):");
			if (guiInput == 0) {
				System.out.println("Exiting program ...");
				System.exit(0);
			}
			try {
				ph.isTicketAlreadyPayed(guiInput);
				PayTicket(guiInput, ph);
			} catch (TicketAlreadyPayedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
