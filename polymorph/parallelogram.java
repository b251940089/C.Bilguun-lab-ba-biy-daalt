package polymorph;

	public class parallelogram implements Shape {
	    double base, height;

	    public parallelogram(double base, double height) {
	        this.base = base;
	        this.height = height;
	    }

	    public double calculateArea() {
	        return base * height;
	    }

	    public void display() {
	        System.out.printf("Параллелограммын талбай (s=a*h) = %.2f\n", calculateArea());
	    }
	}
