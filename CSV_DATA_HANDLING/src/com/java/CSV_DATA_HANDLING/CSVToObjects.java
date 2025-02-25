package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    private int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Age=" + age +
                ", Marks=" + marks +
                '}';
    }
}

public class CSVToObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line = br.readLine(); // Skip the header row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Student student = new Student(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }
}