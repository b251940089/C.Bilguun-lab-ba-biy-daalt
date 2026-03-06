package lab2;
import java.util.Scanner;
public class dundaj {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("First number: ");
		double a = s.nextDouble();
		
		System.out.print("Second number: ");
		double b = s.nextDouble();
		
		double arif = (a + b) / 2;
		double geo = Math.sqrt(a * b);
		
		System.out.println("Ariphmetic dundaj: " + arif);
		System.out.println("Geometr dundaj: " + geo);
		
		s.close();
		
	}

}

