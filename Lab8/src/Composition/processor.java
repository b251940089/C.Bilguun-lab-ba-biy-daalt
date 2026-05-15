package Composition;

public class processor {
	private String brand;
	private int cores;
	private double speed;
	private int cache;

	public processor(String brand, int cores, double speed, int cache) {
		this.brand = brand;
		this.cores = cores;
		this.speed = speed;
		this.cache = cache;
	}

	public void printInfo() {
		System.out.println("-- Processor --");
		System.out.println("Brand: " + brand);
		System.out.println("Cores: " + cores);
		System.out.println("Speed: " + speed + " GHz");
		System.out.println("Cache: " + cache + " MB");
	}
}
