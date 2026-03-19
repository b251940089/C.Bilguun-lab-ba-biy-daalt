package biydaalt1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("School: ");
        String school = sc.nextLine();

        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Score: ");
        double score = sc.nextDouble();

        Student student1 = new Student(firstName, lastName, age, department, score, school);

        System.out.println();
        student1.displayInfo();

        sc.close();
    }
}


class Student {


    private String firstName;
    private String lastName;
    private int age;
    private String department;
    private double score;
    private String school;

    public Student() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
        this.department = "None";
        this.score = 0.0;
        this.school = "Unknown School";
    }

    public Student(String firstName, String lastName, int age,
                   String department, double score, String school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
        this.score = score;
        this.school = school;
    }

    private double calculateBonus() {
        return score * 0.1;
    }

    private String evaluatePerformance() {
        if (score >= 90) {
            return "Excellent";
        } else if (score >= 75) {
            return "Good";
        } else if (score >= 60) {
            return "Average";
        } else {
            return "Less than average";
        }
        
    }
    private double calculateGPA() {
        if (score >= 90) {
            return 4.0;
        } else if (score >= 80) {
            return 3.0;
        } else if (score >= 70) {
            return 2.0;
        } else if (score >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
    public void displayInfo() {
        System.out.println("------ Student Information ------");
        System.out.println("School: " + school);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Score: " + score);
        System.out.println("GPA: " + calculateGPA());
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Performance: " + evaluatePerformance());
    }

    public static void showMessage() {
        System.out.println("Student Registration System");
    }
}