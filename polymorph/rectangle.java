package polymorph;

	public class rectangle implements Shape {
	    double width, height;

	    public rectangle(double width, double height) {
	        this.width = width;
	        this.height = height;
	    }

	    public double calculateArea() {
	        return width * height;
	    }

	    public void display() {
	        System.out.printf("Тэгш өнцөгтийн талбай (s=a*b) = %.2f\n", calculateArea());
	    } }
