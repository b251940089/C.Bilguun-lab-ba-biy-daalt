package Clocksystem;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class clock {
	private int year;
	private int month;
	private int day;
	private int time;
	private int minute;
	private int second;
	private LocalDateTime ldt;
	private DateTimeFormatter formatter;

	public clock() {
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	}

	// gar argaar tsag tokhiruulakh
	public void setClock(int y, int mon, int d, int t, int min, int s) {
		year = y;
		month = mon;
		day = d;
		time = t;
		minute = min;
		second = s;
		ldt = LocalDateTime.of(year, month, day, time, minute, second);
		System.out.println("Tsag tokhiruulagdlaa: " + ldt.format(formatter));
	}

	// systemiin tsagaar avtomataar avna
	public void autoSetClock() {
		ldt = LocalDateTime.now();
		year = ldt.getYear();
		month = ldt.getMonthValue();
		day = ldt.getDayOfMonth();
		time = ldt.getHour();
		minute = ldt.getMinute();
		second = ldt.getSecond();
		System.out.println("Auto tsag: " + ldt.format(formatter));
	}

	//1000 sec
	public void tickClock() {
		tickClock(1000);
	}

	public void tickClock(int tick) {
		if (ldt == null) {
			System.out.println("Eshleed tsag tokhiruulna uu!");
			return;
		}

		System.out.println("Clock ekhellee - " + tick + " second");

		for (int i = 0; i < tick; i++) {
			System.out.println(ldt.format(formatter));
			ldt = ldt.plusSeconds(1);
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("aldaa: " + e.getMessage());
				break;
			}
		}

		System.out.println("Clock duuslaa.");
	}
}
