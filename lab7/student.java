package lab7;

public class student {
    private String name;
    private int age;
    private String studentId;
    // метод
    public student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId; }
    // Мэдээллийг харуулах toString
    @Override
    public String toString() {
        return "ID: " + studentId + " | Нэр: " + name + " | Нас: " + age; }
    // Эрэмбэлэх 
    public String getName() { return name; }
    public String getStudentId() { return studentId; }}