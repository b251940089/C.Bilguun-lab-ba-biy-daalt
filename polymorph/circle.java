package polymorph;

	public class circle implements Shape {
	    double radius;

	    public circle(double radius) {
	        this.radius = radius;
	    }

	    public double calculateArea() {
	        return Math.PI * radius * radius;
	    }

	    public void display() {
	        System.out.printf("Тойргийн талбай (s=π*r^2) = %.2f\n", calculateArea());
	    }
	}
