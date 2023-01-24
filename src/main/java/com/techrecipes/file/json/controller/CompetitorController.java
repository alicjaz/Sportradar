package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.EventPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CompetitorController {

    @Autowired
    private EventPrinter eventPrinter;

    public CompetitorController(EventPrinter eventPrinter) {
        this.eventPrinter = eventPrinter;
    }

    @GetMapping("/teams/{competitionName}")
    public String printCompetitorNames(@PathVariable String competitionName, Model model) {
        List<String> competitorNames = eventPrinter.printCompetitorNames(competitionName);
        model.addAttribute("teams", competitorNames);
        return "competitors";
    }

}