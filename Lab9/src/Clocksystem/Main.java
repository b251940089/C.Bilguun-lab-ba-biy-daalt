package Clocksystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		clock c = new clock();

		System.out.println("=== Clock System ===");

		// tsag tokhiruulakh songolt
		System.out.println("1. Auto (systemiin tsag)");
		System.out.println("2. Gar argaar");
		System.out.print("Songolt: ");
		int choice1 = sc.nextInt();

		if (choice1 == 1) {
			c.autoSetClock();
		} else if (choice1 == 2) {
			System.out.print("Jil: ");
			int y = sc.nextInt();
			System.out.print("Sar: ");
			int mon = sc.nextInt();
			System.out.print("Odor: ");
			int d = sc.nextInt();
			System.out.print("Tsag: ");
			int h = sc.nextInt();
			System.out.print("Minut: ");
			int min = sc.nextInt();
			System.out.print("Second: ");
			int s = sc.nextInt();
			c.setClock(y, mon, d, h, min, s);
		} else {
			System.out.println("buruu songolt, auto bolgoloo");
			c.autoSetClock();
		}

		// tick songolt
		System.out.println("1. 1000 second");
		System.out.println("2. Oo'roo tokhiruulakh");
		System.out.print("Songolt: ");
		int choice2 = sc.nextInt();

		if (choice2 == 1) {
			c.tickClock();
		} else if (choice2 == 2) {
			System.out.print("Heden second: ");
			int tick = sc.nextInt();
			c.tickClock(tick);
		} else {
			c.tickClock();
		}

		sc.close();
	}
}
