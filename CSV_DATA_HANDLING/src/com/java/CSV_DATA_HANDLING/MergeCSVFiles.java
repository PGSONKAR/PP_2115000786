package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        Map<String, String[]> studentData = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"))) {
            String line = br1.readLine(); // Skip the header row
            while ((line = br1.readLine()) != null) {
                String[] values = line.split(",");
                studentData.put(values[0], new String[]{values[1], values[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"))) {
            String line = br2.readLine(); // Skip the header row
            while ((line = br2.readLine()) != null) {
                String[] values = line.split(",");
                if (studentData.containsKey(values[0])) {
                    String[] existingData = studentData.get(values[0]);
                    studentData.put(values[0], new String[]{existingData[0], existingData[1], values[1], values[2]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("merged_students.csv")) {
            writer.append("ID,Name,Age,Marks,Grade\n");
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                String[] values = entry.getValue();
                writer.append(entry.getKey()).append(",")
                      .append(values[0]).append(",")
                      .append(values[1]).append(",")
                      .append(values.length > 2 ? values[2] : "").append(",")
                      .append(values.length > 3 ? values[3] : "").append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}