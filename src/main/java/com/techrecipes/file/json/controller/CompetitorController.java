package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetitorController {

    @Autowired
    private EventPrinter eventPrinter;

    public CompetitorController(EventPrinter eventPrinter) {
        this.eventPrinter = eventPrinter;
    }

    @GetMapping("/competitors")
    public List<String> getCompetitorNames() {
        return eventPrinter.printCompetitorNames();
    }
}