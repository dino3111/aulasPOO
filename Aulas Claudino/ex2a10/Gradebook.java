package ex2a10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Gradebook {
    private Map<String, Student> students;

    public Gradebook() {
        this.students = new HashMap<>();
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0].trim();
                List<Double> grades = new ArrayList<>();

                for (int i = 1; i < parts.length; i++) {
                    grades.add(Double.parseDouble(parts[i].trim()));
                }
                Student s = new Student(name, grades);
                addStudent(s);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void addStudent(Student s) {
        students.put(s.getName(), s);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public Student getStudent(String name) {
        return students.get(name);
    }

    public double calculateAverageGrade(String name) {
        Student s = students.get(name);
        if (s == null) return 0.0;
        List<Double> grades = s.getGrades();
        if (grades.isEmpty()) return 0.0;

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    public void printAllStudents() {
        for (Student s : students.values()) {
            System.out.println(s);
        }
    }
}
