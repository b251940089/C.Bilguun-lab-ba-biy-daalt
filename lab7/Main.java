package lab7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        studentmanager manager = new studentmanager();
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Оюутан нэмэх");
            System.out.println("2. Оюутан устгах");
            System.out.println("3. Оюутан хайх");
            System.out.println("4. Эрэмбэлэх");
            System.out.println("5. Бүх оюутны мэдээлэл харах");
            System.out.println("6. Гарах");
            System.out.print("Сонголт: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            if (choice == 1) {
                System.out.print("Нэр: ");
                String name = sc.nextLine();
                System.out.print("Нас: ");
                int age = sc.nextInt();
                sc.nextLine(); 
                System.out.print("ID: ");
                String id = sc.nextLine();
                manager.addStudent(new student(name, age, id));
            } else if (choice == 2) {
                System.out.print("Устгах ID: ");
                manager.removeStudent(sc.nextLine());
            } else if (choice == 3) {
                System.out.print("Хайх ID: ");
                student s = manager.findStudent(sc.nextLine());
                System.out.println(s != null ? s : "Оюутан олдсонгүй.");
            } else if (choice == 4) {
                manager.sortByName();
                System.out.println("Нэрээр эрэмбэллээ.");
            } else if (choice == 5) {
                manager.printAllStudents();
            } else if (choice == 6) {
                System.out.println("Програм дууслаа.");
                break;
            } else {
                System.out.println("Буруу сонголт!");
            }
        }
        sc.close();
    }
}