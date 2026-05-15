package lab10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ovog: ");
		String surname = sc.nextLine();
		System.out.print("Ner: ");
		String name = sc.nextLine();
		System.out.print("Reg no: ");
		String regNo = sc.nextLine();
		System.out.print("Torson on (yyyy-mm-dd): ");
		String birthDate = sc.nextLine();
		System.out.print("Worker code: ");
		String workerCode = sc.nextLine();
		System.out.print("Branch: ");
		String branchName = sc.nextLine();
		System.out.print("Ajild orson ogno (yyyy-mm-dd): ");
		String startDate = sc.nextLine();

		System.out.println();

		worker w = new worker(surname, name, regNo, birthDate, workerCode, branchName, startDate);
		w.info();

		sc.close();
	}
}
