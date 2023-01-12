package com.techrecipes.file.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class Root {
    @JsonProperty("Events")
    public ArrayList<Event> events;

    public Root() {

    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Root{" +
                "events=" + events +
                '}';
    }
}





