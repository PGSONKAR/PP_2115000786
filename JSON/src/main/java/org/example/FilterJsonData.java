package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJsonData {
    public static void main(String[] args) {
        String jsonArray = """
        [
            {"name": "John Doe", "age": 30, "email": "john.doe@example.com"},
            {"name": "Jane Smith", "age": 22, "email": "jane.smith@example.com"},
            {"name": "Emily Johnson", "age": 28, "email": "emily.johnson@example.com"}
        ]
        """;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonArray);
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    if (node.path("age").asInt() > 25) {
                        System.out.println(node.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}