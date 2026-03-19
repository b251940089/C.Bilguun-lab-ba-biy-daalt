package lab5;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Хэдэн тоон дээр статистик үйлдэл хийх вэ (2-5): ");
        int n = sc.nextInt();
        double a[] = new double[n];
        for(int i = 0; i < n; i++) {
            System.out.printf("%d-р тоог оруул: ", i + 1);
            a[i] = sc.nextDouble();
        }
        System.out.println("\n--- Varargs method ---");
        double meanVar = Statistics.mean(a);
        double stdVar = Statistics.stdDev(a);
        System.out.println("Mean = " + meanVar);
        System.out.println("Standard Deviation = " + stdVar);
        System.out.println("\n--- Overloaded method ---");
        if(n == 2)
            System.out.println("Mean(дундаж утга) = " + Statistics.mean(a[0], a[1]));
        else if(n == 3)
            System.out.println("Mean = " + Statistics.mean(a[0], a[1], a[2]));
        else if(n == 4)
            System.out.println("Mean = " + Statistics.mean(a[0], a[1], a[2], a[3]));
        else if(n == 5)
            System.out.println("Mean = " + Statistics.mean(a[0], a[1], a[2], a[3], a[4]));
        sc.close();
    }
}