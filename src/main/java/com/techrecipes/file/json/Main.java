package com.techrecipes.file.json;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File jsonFile = new File("src/main/resources/BE_data.json");
            EventPrinter eventPrinter = new EventPrinter(jsonFile);
            eventPrinter.printEvents(1000000);
            //eventPrinter.printCompetitorNames();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}