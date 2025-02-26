package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String json1 = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";
            String json2 = "{\"age\": 30, \"city\": \"New York\"}";

            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            ObjectNode merged = objectMapper.createObjectNode();
            merged.setAll((ObjectNode) node1);
            merged.setAll((ObjectNode) node2);

            System.out.println(merged.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}