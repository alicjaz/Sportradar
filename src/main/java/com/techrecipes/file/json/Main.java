package com.techrecipes.file.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        try {
            EventPrinter eventPrinter = new EventPrinter();
            eventPrinter.printEvents(10);
            //eventPrinter.printCompetitorNames("sr:competition:7");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}