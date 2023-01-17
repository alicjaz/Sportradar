package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.Event;
import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventPrinter eventPrinter;

    @GetMapping("/events")
    public List<Event> printEvents(@RequestParam(defaultValue = "30") int numberOfEvents) {
        List<Event> events = eventPrinter.getEvents(numberOfEvents);
        return events;
    }

    @GetMapping("/events/{numberOfEvents}")
    public ResponseEntity<List<Event>> getEvents(@PathVariable int numberOfEvents) {
        List<Event> events = eventPrinter.getEvents(numberOfEvents);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}