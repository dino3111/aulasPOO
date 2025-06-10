package aula10.ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Gradebook {

    private List<Student> students;
    private IGradeCalculator gradeCalculator;

    public Gradebook() {
        this.students = new ArrayList<>();
        this.gradeCalculator = new SimpleAverageCalculator(); 
    }

    public void load(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                List<Double> grades = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    grades.add(Double.parseDouble(parts[i]));
                }
                students.add(new Student(name, grades));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equalsIgnoreCase(name));
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public double calculateAverageGrade(String name) {
        Student student = getStudent(name);
        if (student != null) {
            return gradeCalculator.calculate(student.getGrades());
        } else {
            System.err.println("Aluno não encontrado: " + name);
            return 0.0;
        }
    }

    public void printAllStudents() {
        for (Student student : students) {
            System.out.println("Nome: " + student.getName() +
                    ", Notas: " + student.getGrades() +
                    ", Média: " + calculateAverageGrade(student.getName()));
        }
    }

    public void setGradeCalculator(IGradeCalculator calculator) {
        this.gradeCalculator = calculator;
    }

    public void saveAllStudentsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.println("Nome: " + student.getName() +
                               ", Notas: " + student.getGrades() +
                               ", Média: " + calculateAverageGrade(student.getName()));
            }
            System.out.println("Dados salvos em: " + filename);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no ficheiro: " + e.getMessage());
        }
    }    
}

