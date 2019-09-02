package com.anirban.basicsynchronization.synchronizedblock;

public class TicketOffice1 implements Runnable{
	private Cinema cinema;
	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void run() {
		System.out.print("TicketOffice1: ");
		cinema.sellTicket1(3);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket1(2);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice1: ");
		cinema.returnTicket1(3);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket1(5);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(2);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(4);
		System.out.print("TicketOffice1: ");
		cinema.sellTicket2(1);
	}
	

}
