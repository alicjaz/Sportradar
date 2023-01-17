package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.EventPrinter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competitors")
public class CompetitorController {

    private EventPrinter eventPrinter;

    public CompetitorController(EventPrinter eventPrinter) {
        this.eventPrinter = eventPrinter;
    }

    @GetMapping
    public void getCompetitorNames() {
        eventPrinter.printCompetitorNames();
    }
}