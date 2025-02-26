package org.example;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ValidateEmailWithJsonSchema {
    public static void main(String[] args) {
        String jsonString = """
        {
            "email": "john.doe@example.com"
        }
        """;

        String schemaString = """
        {
            "type": "object",
            "properties": {
                "email": {
                    "type": "string",
                    "format": "email"
                }
            },
            "required": ["email"]
        }
        """;

        JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaString));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(jsonString));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
            System.out.println("Email is valid.");
        } catch (Exception e) {
            System.out.println("Email is invalid: " + e.getMessage());
        }
    }
}