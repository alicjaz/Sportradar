package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.Competitor;
import com.techrecipes.file.json.Event;
import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompetitorController {

    @Autowired
    private EventPrinter eventPrinter;

    public CompetitorController(EventPrinter eventPrinter) {
        this.eventPrinter = eventPrinter;
    }

    @GetMapping("/teams/{competitionName}")
    public List<String> printCompetitorNames(@PathVariable String competitionName) {
        return eventPrinter.printCompetitorNames(competitionName);
    }

}