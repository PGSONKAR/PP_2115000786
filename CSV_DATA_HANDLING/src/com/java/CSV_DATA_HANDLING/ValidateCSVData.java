package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader("contacts.csv"))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Matcher emailMatcher = emailPattern.matcher(values[2]);
                Matcher phoneMatcher = phonePattern.matcher(values[3]);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email format: " + values[2] + " in row: " + line);
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number: " + values[3] + " in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}