package polymorph;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Талбайг нь тооцоолох дүрсийн нэрийг оруул: ");
        String type = sc.nextLine();

        Shape shape = null;

        switch (type.toLowerCase()) {

            case "square":
                System.out.print("Талыг оруул (a): ");
                double a = sc.nextDouble();
                shape = new square(a);
                break;

            case "rectangle":
                System.out.print("Уртыг оруул (a): ");
                double r1 = sc.nextDouble();
                System.out.print("Өргөнийг оруул (b): ");
                double r2 = sc.nextDouble();
                shape = new rectangle(r1, r2);
                break;

            case "triangle":
                System.out.print("Суурь (a): ");
                double t1 = sc.nextDouble();
                System.out.print("Өндөр (h): ");
                double t2 = sc.nextDouble();
                shape = new triangle(t1, t2);
                break;

            case "circle":
                System.out.print("Радиус (r): ");
                double r = sc.nextDouble();
                shape = new circle(r);
                break;

            case "trapezoid":
                System.out.print("a: ");
                double ta = sc.nextDouble();
                System.out.print("b: ");
                double tb = sc.nextDouble();
                System.out.print("h: ");
                double th = sc.nextDouble();
                shape = new trapezoid(ta, tb, th);
                break;

            case "sector":
                System.out.print("r: ");
                double sr = sc.nextDouble();
                System.out.print("angle: ");
                double sa = sc.nextDouble();
                shape = new sector(sr, sa);
                break;

            case "ellipse":
                System.out.print("a: ");
                double ea = sc.nextDouble();
                System.out.print("b: ");
                double eb = sc.nextDouble();
                shape = new ellipse(ea, eb);
                break;

            case "parallelogram":
                System.out.print("base: ");
                double pb = sc.nextDouble();
                System.out.print("height: ");
                double ph = sc.nextDouble();
                shape = new parallelogram(pb, ph);
                break;

            default:
                System.out.println("Буруу дүрсийн нэр!");
                return;
        }

        shape.display();
        sc.close();
    }
}