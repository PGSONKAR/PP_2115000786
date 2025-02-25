package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            br.readLine(); 
            while (br.readLine() != null) {
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of records: " + rowCount);
    }
}