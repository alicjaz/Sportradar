package com.techrecipes.file.json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController is a Spring MVC controller that handles the root path '/' and maps it to the 'index' view.
 */
@Controller
public class HomeController {
    /**
     * Handles the root path '/' and maps it to the 'index' view.
     * @return the name of the 'index' view
     */
    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
