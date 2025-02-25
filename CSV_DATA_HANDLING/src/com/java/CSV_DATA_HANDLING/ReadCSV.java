package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println("ID: " + values[0] + ", Name: " + values[1] + ", Age: " + values[2] + ", Marks: " + values[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}