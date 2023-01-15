package com.techrecipes.file.json;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EventPrinter {

    private final ObjectMapper objectMapper;
    private final File jsonFile;

    public EventPrinter(File jsonFile) {
        this.jsonFile = jsonFile;
        this.objectMapper = new ObjectMapper();
    }

    public void printEvents(int numberOfEvents) {
        try {
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            int count = 0;
            for (Event event : events) {
                String venue = String.valueOf(event.getVenue());
                if (venue != null && count < numberOfEvents) {
                    Date startDate = event.getStart_date();
                    String homeTeam = event.getCompetitors().get(0).getName();
                    String awayTeam = event.getCompetitors().get(1).getName();
                    double homeTeamWinProb = event.getProbability_home_team_winner();
                    System.out.println("Start date: " + startDate);
                    System.out.println(homeTeam + " vs. " + awayTeam);
                    System.out.println("Venue: " + venue);
                    System.out.println("Highest probable result: HOME_TEAM_WIN" + " (" + homeTeamWinProb + ")");
                    System.out.println(" ");
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}