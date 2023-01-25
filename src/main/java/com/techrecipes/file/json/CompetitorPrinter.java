package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class CompetitorPrinter {

    public ObjectMapper objectMapper;
    public File jsonFile;

    public CompetitorPrinter(File jsonFile) {
        // Initialize jsonFile and objectMapper fields
        this.jsonFile = jsonFile;
        this.objectMapper = new ObjectMapper();
    }

    public List<String> getCompetitorNames(String competitionId) {
        // Initialize namesList as null
        List<String> namesList = null;
        try {
            // Read data from jsonFile and map it to Root class object
            Root root = objectMapper.readValue(jsonFile, Root.class);
            List<Event> events = root.getEvents();
            // Create a set to store unique team names
            Set<String> teamNames = new HashSet<>();
            // Iterate over events and get the team names for the given competitionId
            for (Event event : events) {
                if (event.getCompetition_id().equals(competitionId)) {
                    for (Competitor competitor : event.getCompetitors()) {
                        teamNames.add(competitor.getName());
                    }
                }
            }
            // Convert set to list and sort the list
            namesList = new ArrayList<String>(teamNames);
            Collections.sort(namesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return namesList;
    }
}