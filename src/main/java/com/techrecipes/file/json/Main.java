package com.techrecipes.file.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        try {
            // File path of the JSON data
            File jsonFile = new File("src/main/resources/BE_data.json");
            // Create an instance of EventPrinter
            EventPrinter eventPrinter = new EventPrinter(jsonFile);
            // Print the events from the JSON data
            eventPrinter.printEvents(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}