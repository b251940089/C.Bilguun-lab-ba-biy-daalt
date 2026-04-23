package polymorph;

	public class square implements Shape {
	    double side;

	    public square(double side) {
	        this.side = side;
	    }

	    public double calculateArea() {
	        return side * side;
	    }

	    public void display() {
	        System.out.printf("Квадратын талбай (s=a*a) = %.2f\n", calculateArea());
	    } }
