package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Date;
import java.util.List;

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
                    double drawProb = event.getProbability_draw();
                    double awayTeamWinProb = event.getProbability_away_team_winner();
                    double maxProb = Math.max(homeTeamWinProb, Math.max(drawProb, awayTeamWinProb));
                    String result;
                    if (maxProb == homeTeamWinProb) {
                        result = "HOME_TEAM_WIN";
                    } else if (maxProb == drawProb) {
                        result = "DRAW";
                    } else {
                        result = "AWAY_TEAM_WIN";
                    }

                    System.out.println("Start date: " + startDate);
                    System.out.println(homeTeam + " vs. " + awayTeam);
                    System.out.println("Venue: " + venue);
                    System.out.println("Highest probable result: " + result + "(" + maxProb + ")");
                    System.out.println(" ");
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}