package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A service class that handles printing and retrieving events from a JSON file.
 */
@Service
public class EventPrinter {

    /**
     * ObjectMapper instance to map JSON data to Java objects
     */
    public ObjectMapper objectMapper;
    public File jsonFile;

    /**
     * Constructor to initialize the JSON file and ObjectMapper
     *
     * @param jsonFile the JSON file containing the events
     */
    public EventPrinter(File jsonFile) {
        this.jsonFile = jsonFile;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Prints a specified number of events to the console
     *
     * @param numberOfEvents the number of events to print
     */
    public void printEvents(int numberOfEvents) {
        try {
            // read the JSON file and map it to a Root object
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            int count = 0;
            int eventSize = events.size();

            // set number of events to print to the total number of events if the specified number is less than or equal to 0
            // or greater than the total number of events
            if (numberOfEvents <= 0) {
                numberOfEvents = eventSize;
            } else if (numberOfEvents > eventSize) {
                numberOfEvents = eventSize;
            }

            // iterate through the events and print the specified number of events
            for (Event event : events) {
                if (count < numberOfEvents) {
                    String venue = String.valueOf(event.getVenue());
                    if (venue != null) {
                        Date startDate = event.getStart_date();
                        String homeTeam = event.getCompetitors().get(0).getName();
                        String awayTeam = event.getCompetitors().get(1).getName();
                        String HighestProbableResult = event.HighestProbableResult();
                        double maxProb = event.HighestProbability();

                        System.out.println("Start date: " + startDate);
                        System.out.println(homeTeam + " (" + event.getCompetitors().get(0).getCountry() + ")" + " vs. " + awayTeam + " (" + event.getCompetitors().get(1).getCountry() + ")");
                        System.out.println("Venue: " + venue);
                        System.out.println("Highest probable result: " + HighestProbableResult + "(" + maxProb + ")");
                        System.out.println(" ");
                        count++;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a specified number of events from the JSON file
     *
     * @param numberOfEvents the number of events to retrieve
     * @return a list of Event objects
     */
    public List<Event> getEvents(int numberOfEvents) {
        List<Event> selectedEvents = null;
        try {
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            int count = 0;
            int eventSize = events.size();
            if (numberOfEvents <= 0) {
                numberOfEvents = eventSize;
            } else if (numberOfEvents > eventSize) {
                numberOfEvents = eventSize;
            }
            selectedEvents = new ArrayList<>();
            for (Event event : events) {
                if (count < numberOfEvents) {
                    selectedEvents.add(event);
                    count++;
                } else {
                    break;
                }
            }
            return selectedEvents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectedEvents;
    }

}