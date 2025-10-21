import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Aarav", "Java", 85.0, 92.0));
        students.add(new Student(2, "Riya", "Python", 58.0, 88.0));
        students.add(new Student(3, "Karan", "C++", 70.0, 65.0));
        students.add(new Student(4, "Simran", "Java", 95.0, 91.0));
        students.add(new Student(5, "Vivek", "C#", 40.0, 75.0));
        students.add(new Student(6, "Anjali", "JavaScript", 82.0, 69.0));
        students.add(new Student(7, "Tina", "Java", 78.0, 55.0));
        students.add(new Student(8, "Rahul", "Python", 68.0, 80.0));
        students.add(new Student(9, "Pooja", "C++", 89.0, 94.0));
        students.add(new Student(10, "Nikhil", "Java", 72.0, 60.0));

        // Calculate grades with exception handling
        for (Student s : students) {
            try {
                s.calculateGrade();
            } catch (LowAttendanceException e) {
                System.out.println(e.getMessage());
            }
        }

        // 4️⃣ Serialization: store in file
        try (PrintWriter pw = new PrintWriter(new FileWriter("student.txt"))) {
            for (Student s : students) {
                pw.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5️⃣ Sort students in decreasing order of attendance
        students.sort((s1, s2) -> Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage()));

        System.out.println("\n Students in decreasing order of attendance:");
        for (Student s : students) {
            System.out.println(s);
        }

    }
}