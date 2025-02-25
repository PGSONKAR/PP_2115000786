package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class FilterCSVRecords {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line = br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int marks = Integer.parseInt(values[3]);
                if (marks > 80) {
                    System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Age: " + values[2] + ", Marks: " + values[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}