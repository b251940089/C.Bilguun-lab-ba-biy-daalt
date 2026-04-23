package polymorph;

	public class triangle implements Shape {
	    double base, height;

	    public triangle(double base, double height) {
	        this.base = base;
	        this.height = height;
	    }

	    public double calculateArea() {
	        return 0.5 * base * height;
	    }

	    public void display() {
	        System.out.printf("Гурвалжны талбай (s=1/2*a*h) = %.2f\n", calculateArea());
	    }
	}