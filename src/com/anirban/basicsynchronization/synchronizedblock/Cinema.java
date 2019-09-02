package com.anirban.basicsynchronization.synchronizedblock;

public class Cinema {
	private final Object cinemaControl1;
	private final Object cinemaControl2;
	private int vacanciesCinema1;
	private int vacanciesCinema2;

	public Cinema() {
		this.cinemaControl1 = new Object();
		this.cinemaControl2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}

	public int getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public int getVacanciesCinema2() {
		return vacanciesCinema2;
	}

	public boolean sellTicket1(int count) {
		synchronized (cinemaControl1) {
			if (vacanciesCinema1 > count) {
				vacanciesCinema1 -= count;
				System.out.println(count + " Tickets sold from screen 1. Current vacancie(s): " + vacanciesCinema1);
				return true;
			} else {
				System.out.println("Sorry, no tickets are available in screen 1");
				return false;
			}
		}
	}

	public boolean sellTicket2(int count) {
		synchronized (cinemaControl2) {
			if (vacanciesCinema2 > count) {
				vacanciesCinema2 -= count;
				System.out.println(count + " Tickets sold from screen 2. Current vacancie(s): " + vacanciesCinema2);
				return true;
			} else {
				System.out.println("Sorry, no tickets are available in screen 2");
				return false;
			}
		}
	}

	public boolean returnTicket1(int count) {
		synchronized (cinemaControl1) {
			if ((vacanciesCinema1 + count) < 20) {
				vacanciesCinema1 += count;
				System.out.println(count + " Tickets returned from screen 1. Current vacancie(s): " + vacanciesCinema1);
				return true;
			} else {
				System.out.println();
				return false;
			}
		}
	}

	public boolean returnTicket2(int count) {
		synchronized (cinemaControl2) {
			if ((vacanciesCinema2 + count) < 20) {
				vacanciesCinema2 += count;
				System.out.println(count + " Tickets returned from screen 2. Current vacancie(s): " + vacanciesCinema2);
				return true;
			} else {
				System.out.println();
				return false;
			}
		}
	}
}
