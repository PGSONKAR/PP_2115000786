package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        records.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));

        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] record = records.get(i);
            System.out.println("ID: " + record[0] + ", Name: " + record[1] + ", Department: " + record[2] + ", Salary: " + record[3]);
        }
    }
}