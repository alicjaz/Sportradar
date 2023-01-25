package com.techrecipes.file.json.controller;

import com.techrecipes.file.json.CompetitorPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// This class is a Spring MVC controller that handles HTTP requests
@Controller
public class CompetitorController {

    // Autowired annotation is used to automatically wire the bean
    // CompetitorPrinter is wired to this controller
    @Autowired
    private CompetitorPrinter competitorPrinter;

    // constructor for the controller
    public CompetitorController(CompetitorPrinter competitorPrinter) {
        this.competitorPrinter = competitorPrinter;
    }

    // GetMapping annotation maps HTTP GET requests onto specific handler methods
    // When a request comes in with the path /teams/{competitionName},
    // this method is called and the value of {competitionName} is passed as a parameter
    @GetMapping("/teams/{competitionName}")
    public String printCompetitorNames(@PathVariable String competitionName, Model model) {
        // get the list of competitor names for the given competition
        List<String> competitorNames = competitorPrinter.getCompetitorNames(competitionName);
        // adding the list of competitor names to the model, to be used by the view
        model.addAttribute("teams", competitorNames);
        // returning the view name
        return "competitors";
    }

}