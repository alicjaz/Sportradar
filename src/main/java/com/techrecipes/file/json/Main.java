package com.techrecipes.file.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        try {
            File jsonFile = new File("src/main/resources/BE_data.json");
            EventPrinter eventPrinter = new EventPrinter();
            eventPrinter.printEvents(5);
            //eventPrinter.printCompetitorNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}