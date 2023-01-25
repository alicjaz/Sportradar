package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.Event;
import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller class for handling requests related to events
 */
@Controller
public class EventController {

    /**
     * Autowired instance of EventPrinter for fetching events
     */
    @Autowired
    private EventPrinter eventPrinter;

    /**
     * Handles GET request for '/events' endpoint
     * @param model Spring MVC model object for adding attributes to the view
     * @param numberOfEvents number of events to be displayed, default is 10
     * @return 'events' view
     */
    @GetMapping("/events")
    public String getEvents(Model model, @RequestParam(defaultValue = "10") int numberOfEvents) {
        List<Event> events = eventPrinter.getEvents(numberOfEvents);
        model.addAttribute("events", events);
        return "events";
    }
}