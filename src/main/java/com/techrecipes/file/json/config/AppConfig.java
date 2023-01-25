package com.techrecipes.file.json.config;

import com.techrecipes.file.json.CompetitorPrinter;
import com.techrecipes.file.json.EventPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Configuration class for the beans in the application
 */
@Configuration
public class AppConfig {

    /**
     * This method creates an EventPrinter bean.
     * It sets the jsonFile property to point to the BE_data.json file.
     *
     * @return an instance of EventPrinter
     */
    @Bean
    public EventPrinter eventPrinter() {
        File jsonFile = new File("src/main/resources/BE_data.json");
        return new EventPrinter(jsonFile);
    }

    /**
     * This method creates an CompetitorPrinter bean.
     * It sets the jsonFile property to point to the BE_data.json file.
     *
     * @return an instance of CompetitorPrinter
     */
    @Bean
    public CompetitorPrinter competitorPrinter() {
        File jsonFile = new File("src/main/resources/BE_data.json");
        return new CompetitorPrinter(jsonFile);
    }
}
