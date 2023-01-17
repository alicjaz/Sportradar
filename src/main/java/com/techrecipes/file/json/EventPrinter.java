package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

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
            int eventSize = events.size();
            if (numberOfEvents <= 0) {
                numberOfEvents = eventSize;
            } else if (numberOfEvents > eventSize) {
                numberOfEvents = eventSize;
            }
            for (Event event : events) {
                if (count < numberOfEvents) {
                    String venue = String.valueOf(event.getVenue());
                    if (venue != null) {
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
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCompetitorNames() {
        try {
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            Set<String> competitorNames = new HashSet<>();
            for (Event event : events) {
                for (Competitor competitor : event.getCompetitors()) {
                    competitorNames.add(competitor.getName());
                }
            }
            List<String> namesList = new ArrayList<String>(competitorNames);
            Collections.sort(namesList);
            for (String name : namesList) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}