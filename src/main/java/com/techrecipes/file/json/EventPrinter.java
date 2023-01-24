package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
public class EventPrinter {

    public ObjectMapper objectMapper;
    public File jsonFile;

    public EventPrinter() {
        this.jsonFile = new File("src/main/resources/BE_data.json");
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

    public List<String> printCompetitorNames(String competitionId) {
        List<String> namesList = null;
        try {
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            Set<String> teamNames = new HashSet<>();
            for (Event event : events) {
                if (event.getCompetition_id().equals(competitionId)) {
                    for (Competitor competitor : event.getCompetitors()) {
                        teamNames.add(competitor.getName());
                    }
                }
            }
            namesList = new ArrayList<String>(teamNames);
            Collections.sort(namesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return namesList;
    }


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