package Composition;

public class Computer {
	private Processor processor;
	private Memory memory;
	private DisplayCard displayCard;
	private SoundCard soundCard;

	public Computer() {
		processor = new Processor("Intel", 8, 3.6, 16);
		memory = new Memory(16, "DDR4", 3200, "Samsung");
		displayCard = new DisplayCard(8, "RTX 3060", "Nvidia", 1777);
		soundCard = new SoundCard(7, 192000, "Creative", "PCIe");
	}

	public void showInfo() {
		System.out.println("=== Computer Info ===");
		processor.printInfo();
		System.out.println();
		memory.printInfo();
		System.out.println();
		displayCard.printInfo();
		System.out.println();
		soundCard.printInfo();
	}
}
