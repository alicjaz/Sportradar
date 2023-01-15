package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            ObjectMapper om = new ObjectMapper();
            File jsonFile = new File("src/main/resources/BE_data.json");
            Root root = om.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            EventPrinter eventPrinter = new EventPrinter(jsonFile);
            eventPrinter.printEvents(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}