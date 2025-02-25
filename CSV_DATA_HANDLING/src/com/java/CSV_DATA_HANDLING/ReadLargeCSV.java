package com.java.CSV_DATA_HANDLING;

import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("largefile.csv"))) {
            String line = br.readLine(); 
            while (line != null) {
                int linesProcessed = 0;
                while (line != null && linesProcessed < batchSize) {
                    linesProcessed++;
                    recordCount++;
                    line = br.readLine();
                }
                System.out.println("Processed " + linesProcessed + " records. Total records processed: " + recordCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}