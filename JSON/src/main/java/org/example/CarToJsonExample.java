package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJsonExample {
    public static void main(String[] args) {
        try {
            Cars car = new Cars("Toyota", "Camry", 2020);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(car);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Cars {
    private String make;
    private String model;
    private int year;

    public Cars(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}