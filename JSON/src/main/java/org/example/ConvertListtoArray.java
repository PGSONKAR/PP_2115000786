package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ConvertListtoArray {
    public static void main(String[] args) {
        List<Carss> cars = new ArrayList<>();
        cars.add(new Carss("Toyota", "Camry", 2020));
        cars.add(new Carss("Honda", "Accord", 2021));
        cars.add(new Carss("Ford", "Mustang", 2022));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonArray = objectMapper.writeValueAsString(cars);
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Carss {
    private String make;
    private String model;
    private int year;

    public Carss(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}