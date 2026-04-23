package polymorph;

	public class ellipse implements Shape {
	    double a, b;

	    public ellipse(double a, double b) {
	        this.a = a;
	        this.b = b;
	    }

	    public double calculateArea() {
	        return Math.PI * a * b;
	    }

	    public void display() {
	        System.out.printf("Эллипсийн талбай (s=π*a*b) = %.2f\n", calculateArea());
	    }
	}
