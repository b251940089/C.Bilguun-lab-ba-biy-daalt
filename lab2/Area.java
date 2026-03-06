package lab2;

import java.util.Scanner;
public class Area {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("A tsegiin ax, ay: ");
		double ax = input.nextDouble();
		double ay = input.nextDouble();
		
		System.out.println("B tsegiin bx, by: ");
		double bx = input.nextDouble();
		double by = input.nextDouble();
		
		System.out.println("C tsegiin cx, cy: ");
		double cx = input.nextDouble();
		double cy = input.nextDouble();
		
        double a = Math.sqrt((cx - bx) * (cx - bx) + (cy - by) * (cy - by));
        double b = Math.sqrt((bx - ax) * (bx - ax) + (by - ay) * (by - ay));
        double c = Math.sqrt((cx - ax) * (cx - ax) + (cy - ay) * (cy - ay));
		
		double s = (a + b + c) / 2;
		double A = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		
		System.out.println("Gurvaljinii talbai: " + A);
		
		input.close();
		
	}

}
