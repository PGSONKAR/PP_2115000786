package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IPLJsonProcessor {
    public static void processJson(String inputFilePath, String outputFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<IPLMatch> matches = objectMapper.readValue(new File(inputFilePath), new TypeReference<List<IPLMatch>>() {});

        IPLCensor.applyCensorship(matches);

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFilePath), matches);
    }
}