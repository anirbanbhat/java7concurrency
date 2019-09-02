package com.anirban.basicsynchronization.synchronizedblock;

public class TicketOffice2 implements Runnable {
	private Cinema cinema;
	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		System.out.print("TicketOffice2: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket2(4);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket1(2);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket1(1);
		System.out.print("TicketOffice2: ");
		cinema.returnTicket2(2);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket1(5);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket1(2);
		System.out.print("TicketOffice2: ");
		cinema.sellTicket2(2);
	}

}
