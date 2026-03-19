package lab7;
import java.util.*;

public class studentmanager {
    private List<student> students;
    public studentmanager() {
        students = new ArrayList<>();}
    public void addStudent(student s) {
        students.add(s);}
    public void removeStudent(String studentId) {
        // Оюутныг ID-аар нь олж устгах 
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(studentId)) {
                students.remove(i);
                System.out.println("Оюутан амжилттай устгагдлаа.");
                return;} }
        System.out.println("Ийм ID-тай оюутан олдсонгүй.");}
    public student findStudent(String studentId) {
        for (student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;}}
        return null;}
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Жагсаалт хоосон байна.");
        } else {
            for (student s : students) {
                System.out.println(s);}}}
    public void sortByName() {
        // Collections.sort 
        students.sort(new Comparator<student>() {
            @Override
            public int compare(student s1, student s2) {
                return s1.getName().compareTo(s2.getName()); }});}
}