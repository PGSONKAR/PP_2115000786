package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String[] headers = {"ID", "Name", "Department", "Salary"};
        String[][] employees = {
            {"1", "Alice Johnson", "HR", "50000"},
            {"2", "Bob Smith", "Engineering", "75000"},
            {"3", "Charlie Brown", "Marketing", "60000"},
            {"4", "Diana Prince", "Finance", "65000"},
            {"5", "Evan Davis", "Sales", "55000"}
        };

        try (FileWriter writer = new FileWriter("employees.csv")) {
            writer.append(String.join(",", headers)).append("\n");
            for (String[] employee : employees) {
                writer.append(String.join(",", employee)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}