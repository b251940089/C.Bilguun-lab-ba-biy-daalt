package lab10;

public class person {
	protected String surname;
	protected String name;
	protected String regNo;
	protected String birthDate;

	public person(String surname, String name, String regNo, String birthDate) {
		this.surname = surname;
		this.name = name;
		this.regNo = regNo;
		this.birthDate = birthDate;
	}

	// ovgiin ekhni usgeer + ner => G.Batchuluun
	protected String getFullName(String surname, String name) {
		String firstLetter = surname.substring(0, 1);
		return firstLetter + "." + name;
	}

	// date format: yyyy-mm-dd gej uzmeer baina
	protected int getYear(String date) {
		String[] parts = date.split("-");
		return Integer.parseInt(parts[0]);
	}

	protected int getMonth(String date) {
		String[] parts = date.split("-");
		return Integer.parseInt(parts[1]);
	}

	protected int getDay(String date) {
		String[] parts = date.split("-");
		return Integer.parseInt(parts[2]);
	}

	protected void info() {
		System.out.println("Ovog ner: " + getFullName(surname, name));
		System.out.println("Reg no: " + regNo);
		System.out.println("Torson on: " + getYear(birthDate) + " on " + getMonth(birthDate) + " sar " + getDay(birthDate) + " odor");
	}
}
