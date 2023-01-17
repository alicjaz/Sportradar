package com.techrecipes.file.json.config;

import com.techrecipes.file.json.EventPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfig {

    @Bean
    public EventPrinter eventPrinter() {
        File jsonFile = new File("src/main/resources/BE_data.json");
        return new EventPrinter();
    }
}