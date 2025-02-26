package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class PrintJsonKeyandValue {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));
            printJsonKeysAndValues(rootNode, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJsonKeysAndValues(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJsonKeysAndValues(field.getValue(), prefix + field.getKey() + ": ");
            }
        } else if (node.isArray()) {
            for (JsonNode arrayElement : node) {
                printJsonKeysAndValues(arrayElement, prefix);
            }
        } else {
            System.out.println(prefix + node.asText());
        }
    }
}