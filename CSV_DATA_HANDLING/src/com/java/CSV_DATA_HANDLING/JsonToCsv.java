package com.java.CSV_DATA_HANDLING;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.*;

public class JsonToCsv {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> students = objectMapper.readValue(new File("students.json"), new TypeReference<List<Map<String, Object>>>() {});
            try (FileWriter writer = new FileWriter("students.csv")) {
                if (!students.isEmpty()) {
                    Map<String, Object> headerMap = students.get(0);
                    writer.append(String.join(",", headerMap.keySet())).append("\n");
                    for (Map<String, Object> student : students) {
                        writer.append(String.join(",", student.values().stream().map(String::valueOf).toArray(String[]::new))).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}