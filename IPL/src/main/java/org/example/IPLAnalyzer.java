package org.example;

public class IPLAnalyzer {
    public static void main(String[] args) {
        try {
            IPLJsonProcessor.processJson("ipl_data.json", "censored_ipl_data.json");
            IPLCsvProcessor.processCsv("ipl_data.csv", "censored_ipl_data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}