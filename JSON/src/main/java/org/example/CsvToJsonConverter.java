package org.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        try {
            File csvFile = new File("data.csv");
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
            MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);

            List<Map<String, String>> list = iterator.readAll();
            ObjectMapper jsonMapper = new ObjectMapper();
            String json = jsonMapper.writeValueAsString(list);

            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}