package com.hadinaJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import com.hadinaJmartRK.dbjson.JsonDBEngine;
import com.hadinaJmartRK.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.util.List;
import com.google.gson.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

@SpringBootApplication
public class Jmart {
    public static void main (String[] args){
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}