package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            List<Map<String, Object>> records = new ArrayList<>();
            while (resultSet.next()) {
                Map<String, Object> record = new HashMap<>();
                record.put("id", resultSet.getInt("id"));
                record.put("name", resultSet.getString("name"));
                record.put("email", resultSet.getString("email"));
                // Add more fields as needed
                records.add(record);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writeValueAsString(records);
            System.out.println(jsonReport);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}