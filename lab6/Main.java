package lab6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op;
        // input shalgagch
        while(true){
            System.out.print("Enter operator (+, -, *, /): ");
            op = sc.next();
            if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")){
                break;
            } else {
                System.out.println("Error! Only +, -, *, / are allowed.");}}
        int r1, c1;
        // Matrix 1 dimensions
        while(true){
            System.out.print("Rows of matrix 1: ");
            if(sc.hasNextInt()){
                r1 = sc.nextInt();
                if(r1 > 0) break;
            } else sc.next();
            System.out.println("Error! Enter a positive integer."); }
        while(true){
            System.out.print("Columns of matrix 1: ");
            if(sc.hasNextInt()){
                c1 = sc.nextInt();
                if(c1 > 0) break;
            } else sc.next();
            System.out.println("Error! Enter a positive integer."); }
        int[][] mat1 = new int[r1][c1];
        // Matrix 1 elements
        System.out.println("Enter elements of matrix 1:");
        for(int i=0;i<r1;i++){
            System.out.println("Row " + (i+1) + ":");
            for(int j=0;j<c1;j++){
                while(!sc.hasNextInt()){
                    System.out.println("Error! Enter an integer.");
                    sc.next(); }
                mat1[i][j] = sc.nextInt();}}
        int r2, c2;
        // Matrix 2 dimensions
        while(true){
            System.out.print("Rows of matrix 2: ");
            if(sc.hasNextInt()){
                r2 = sc.nextInt();
                if(r2 > 0) break;}
             else sc.next();
            System.out.println("Error! Enter a positive integer."); }
        while(true){
            System.out.print("Columns of matrix 2: ");
            if(sc.hasNextInt()){
                c2 = sc.nextInt();
                if(c2 > 0) break;}
              else sc.next();
            System.out.println("Error! Enter a positive integer.");}
        // Matrix hemjee shalgagch
        if(op.equals("+") || op.equals("-") || op.equals("/")){
            if(r1 != r2 || c1 != c2){
                System.out.println("Error! Matrices must have the same size for this operation.");
                return;}}
        if(op.equals("*")){
            if(c1 != r2){
                System.out.println("Error! Matrix multiplication not possible with these dimensions.");
                return;}}
        int[][] mat2 = new int[r2][c2];
        // Matrix 2 elements
        System.out.println("Enter elements of matrix 2:");
        for(int i=0;i<r2;i++){
            System.out.println("Row " + (i+1) + ":");
            for(int j=0;j<c2;j++){
                while(!sc.hasNextInt()){
                    System.out.println("Error! Enter an integer.");
                    sc.next();}
                mat2[i][j] = sc.nextInt();}}
        // Create Matrix object and perform operation
        matrix m = new matrix(mat1, mat2, op);
        m.chooseoperation();  }}