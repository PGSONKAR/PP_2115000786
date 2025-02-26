package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode jsonNode1 = objectMapper.readTree(new File("file1.json"));
            JsonNode jsonNode2 = objectMapper.readTree(new File("file2.json"));

            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) jsonNode1);
            mergedNode.setAll((ObjectNode) jsonNode2);

            System.out.println(mergedNode.toPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}