package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class SearchCSVRecord {
    public static void main(String[] args) {
        String searchName = "Alice Johnson"; 
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line = br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + values[2] + ", Salary: " + values[3]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}