package polymorph;

	public class trapezoid implements Shape {
	    double a, b, height;

	    public trapezoid(double a, double b, double height) {
	        this.a = a;
	        this.b = b;
	        this.height = height;
	    }

	    public double calculateArea() {
	        return ((a + b) / 2) * height;
	    }

	    public void display() {
	        System.out.printf("Трапецийн талбай (s=(a+b)/2*h) = %.2f\n", calculateArea());
	    }
	}
