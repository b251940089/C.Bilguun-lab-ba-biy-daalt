package lab2;
import java.util.Scanner;

public class Radius {
  public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    
    double R, NR, sum;
    
    System.out.print("Enter Radius: "); 
    R = input.nextDouble();
    
    sum = R*2*Math.PI ;
    NR= sum*3;
    
    System.out.printf("R of 1 is %f", sum ) ;
    
    System.out.printf("\nAll three are %f", NR);
    input.close();
  }
}