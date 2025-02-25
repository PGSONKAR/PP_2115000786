package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.*;

public class DetectDuplicatesInCSV {
    public static void main(String[] args) {
        Map<String, List<String>> recordsMap = new HashMap<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String header = br.readLine(); 
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                if (recordsMap.containsKey(id)) {
                    duplicates.add(line);
                } else {
                    recordsMap.put(id, Arrays.asList(values));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate records found:");
            for (String duplicate : duplicates) {
                System.out.println(duplicate);
            }
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}