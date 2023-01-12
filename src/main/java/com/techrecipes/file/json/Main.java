package com.techrecipes.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(new File("src/main/resources/BE_data.json"), Root.class);
            System.out.println(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
