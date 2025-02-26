package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class ValidateJsonStructure {
    public static void main(String[] args) {
        String json = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\", \"age\": 30}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println("JSON is valid.");
        } catch (Exception e) {
            System.out.println("JSON is invalid: " + e.getMessage());
        }
    }
}

class Person {
    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}