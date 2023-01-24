package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.Event;
import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventPrinter eventPrinter;

    @GetMapping("/events")
    public String getEvents(Model model, @RequestParam(defaultValue = "-1") int numberOfEvents) {
        List<Event> events = eventPrinter.getEvents(numberOfEvents);
        model.addAttribute("events", events);
        return "events";
    }
}