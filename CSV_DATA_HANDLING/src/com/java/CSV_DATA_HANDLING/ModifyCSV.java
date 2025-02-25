package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.*;

public class ModifyCSV {
    public static void main(String[] args) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line = br.readLine();
            if (line != null) {
                records.add(line.split(","));
            }
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(values[3]);
                    salary *= 1.10;
                    values[3] = String.format("%.2f", salary);
                }
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("updated_employees.csv")) {
            for (String[] record : records) {
                writer.append(String.join(",", record)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}