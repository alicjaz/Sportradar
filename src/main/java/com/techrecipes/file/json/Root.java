package com.techrecipes.file.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {

    @JsonProperty("Events")
    private List<Event> events;

    public Root() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}