package Composition;

public class soundCard {
	private int channels;
	private int sampleRate;
	private String brand;
	private String soundInterface;

	public soundCard(int channels, int sampleRate, String brand, String soundInterface) {
		this.channels = channels;
		this.sampleRate = sampleRate;
		this.brand = brand;
		this.soundInterface = soundInterface;
	}

	public void printInfo() {
		System.out.println("-- Sound Card --");
		System.out.println("Brand: " + brand);
		System.out.println("Channels: " + channels);
		System.out.println("Sample Rate: " + sampleRate + " Hz");
		System.out.println("Interface: " + soundInterface);
	}
}
