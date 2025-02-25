package com.java.CSV_DATA_HANDLING;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        String csvFile = "employees_report.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT id, name, department, salary FROM employees");
             FileWriter writer = new FileWriter(csvFile)) {

            writer.append("Employee ID,Name,Department,Salary\n");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String salary = resultSet.getString("salary");

                writer.append(id).append(",")
                      .append(name).append(",")
                      .append(department).append(",")
                      .append(salary).append("\n");
            }

            System.out.println("CSV report generated successfully.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}