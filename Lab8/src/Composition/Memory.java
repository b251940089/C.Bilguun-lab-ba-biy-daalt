package Composition;

public class Memory {
	private int size;
	private String type;
	private int speed;
	private String brand;

	public Memory(int size, String type, int speed, String brand) {
		this.size = size;
		this.type = type;
		this.speed = speed;
		this.brand = brand;
	}

	public void printInfo() {
		System.out.println("-- Memory --");
		System.out.println("Brand: " + brand);
		System.out.println("Size: " + size + " GB");
		System.out.println("Type: " + type);
		System.out.println("Speed: " + speed + " MHz");
	}
}
