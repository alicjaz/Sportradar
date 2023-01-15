package com.techrecipes.file.json;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techrecipes.file.json.Event;
import com.techrecipes.file.json.Root;
import com.techrecipes.file.json.Venue;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(new File("src/main/resources/BE_data.json"), Root.class);

            List<Event> events = root.getEvents();
            for (Event event : events) {
                Date startDate = event.getStart_date();
                String homeTeam = event.getCompetitors().get(0).getName();
                String awayTeam = event.getCompetitors().get(1).getName();
                double homeTeamWinProb = event.getProbability_home_team_winner();
                String venue = String.valueOf(event.getVenue());
                if (venue == null) {
                } else {
                    System.out.println("Start date: " + startDate);
                    System.out.println(homeTeam + " vs. " + awayTeam);
                    System.out.println("Venue: " + venue);
                    System.out.println("Highest probable result: HOME_TEAM_WIN" + " (" + homeTeamWinProb + ")");
                    System.out.println(" ");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}