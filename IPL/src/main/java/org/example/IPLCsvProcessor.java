package org.example;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IPLCsvProcessor {
    public static void processCsv(String inputFilePath, String outputFilePath) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<IPLMatch> iterator = csvMapper.readerFor(IPLMatch.class).with(schema).readValues(new File(inputFilePath));

        List<IPLMatch> matches = iterator.readAll();
        IPLCensor.applyCensorship(matches);

        CsvSchema outputSchema = csvMapper.schemaFor(IPLMatch.class).withHeader();
        csvMapper.writer(outputSchema).writeValue(new File(outputFilePath), matches);
    }
}