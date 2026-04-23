package polymorph;

	public class sector implements Shape {
	    double radius, angle; // angle in degrees

	    public sector(double radius, double angle) {
	        this.radius = radius;
	        this.angle = angle;
	    }

	    public double calculateArea() {
	        return (angle / 360) * Math.PI * radius * radius;
	    }

	    public void display() {
	        System.out.printf("Секторын талбай (s=θ/360*π*r^2) = %.2f\n", calculateArea());
	    }
	}
