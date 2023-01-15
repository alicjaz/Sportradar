package com.techrecipes.file.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    public String sport_event_id;
    public Date start_date;
    public String sport_name;
    public String competition_name;
    public String competition_id;
    public String season_name;
    public ArrayList<Competitor> competitors;

    @JsonProperty("venue")
    private Venue venue;

    public double probability_home_team_winner;
    public double probability_draw;
    public double probability_away_team_winner;

    public Event() {
    }

    public String getSport_event_id() {
        return sport_event_id;
    }

    public void setSport_event_id(String sport_event_id) {
        this.sport_event_id = sport_event_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public String getSeason_name() {
        return season_name;
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name;
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    /*public ArrayList<Venue> getVenues() {
        return venues;
    }*/

    public void setCompetitors(ArrayList<Competitor> competitors) {
        this.competitors = competitors;
    }

    public double getProbability_home_team_winner() {
        return probability_home_team_winner;
    }

    public void setProbability_home_team_winner(double probability_home_team_winner) {
        this.probability_home_team_winner = probability_home_team_winner;
    }

    public double getProbability_draw() {
        return probability_draw;
    }

    public void setProbability_draw(double probability_draw) {
        this.probability_draw = probability_draw;
    }

    public double getProbability_away_team_winner() {
        return probability_away_team_winner;
    }

    public void setProbability_away_team_winner(double probability_away_team_winner) {
        this.probability_away_team_winner = probability_away_team_winner;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

}


