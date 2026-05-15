package lab10;

public class worker extends person {
	private String workerCode;
	private String branchName;
	private String startDate;

	public worker(String surname, String name, String regNo, String birthDate,
				  String workerCode, String branchName, String startDate) {
		super(surname, name, regNo, birthDate);
		this.workerCode = workerCode;
		this.branchName = branchName;
		this.startDate = startDate;
	}

	// parent-iin info() -g daran tokhiorlood Worker-iin medeelel nemne
	public void info() {
		super.info();
		System.out.println("Worker code: " + workerCode);
		System.out.println("Branch: " + branchName);
		System.out.println("Ajild orson: " + getYear(startDate) + " on " + getMonth(startDate) + " sar " + getDay(startDate) + " odor");
	}
}
